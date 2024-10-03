package com.terminal.api.business;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terminal.api.client.EntryDispatchRequest;
import com.terminal.api.client.EntryDispatchResponse;
import com.terminal.api.client.IngresoDespachoDto;
import com.terminal.api.client.TerminalesSuperTransporte;
import com.terminal.api.client.TerminalesSuperTransportePortType;
import com.terminal.api.client.WSResponse;
import com.terminal.api.dao.IDispatchDao;
import com.terminal.api.entity.EntryDispatchEntity;
import com.terminal.api.model.ProcessControlRequest;
import com.terminal.api.service.DispatchService;
import com.terminal.api.service.ProcessControlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


/**
 * 
 * @author Franklin Pinto
 * @Project Gestion en Terminales
 * @Date 22/08/2024
 * @version 1.0.0
 */

@Service
public class DispatchBusiness implements DispatchService {
	
	@Value("${app.external.ws.supertransporte.username}")
	 private String username;
	 
	@Value("${app.external.ws.supertransporte.password}")
	 private String password;
	 
	
	@Autowired
	IDispatchDao dispatchDao;
	
	@Autowired
	ProcessControlService processControlService;
	
	// Crear un logger para esta clase
    private static final Logger logger = LoggerFactory.getLogger(DispatchBusiness.class);

	 
    public List<EntryDispatchResponse> retrieve(){
    	
    	List<EntryDispatchEntity> entityList =dispatchDao.retrieve();
    	List<EntryDispatchEntity> entityListProcesed = new ArrayList<>();
    	logger.info("** INICIANDO PROCESO TRASFERENCIA DATOS A SUPERTRANSPORTE **");
    	
    	try {
			TerminalesSuperTransportePortType iTerminal = null;
			TerminalesSuperTransporte service = new TerminalesSuperTransporte();
			TerminalesSuperTransportePortType port = service.getTerminalesSuperTransportePort();
			
			ProcessControlRequest req = new ProcessControlRequest();
			ObjectMapper objectMapper = new ObjectMapper();
			String json ="";
			
			for (EntryDispatchEntity d : entityList) {
				
				json = objectMapper.writeValueAsString(d);
				Long numeroLong = convertirStringAPunto(d.getNumeroDespacho());
		        
		        if (numeroLong != null) {
		        	logger.info("Número convertido a Long: " + numeroLong);
		        } else {
		        	logger.error("Error en la conversión.");
		        }
		        
				req.setnConduce(numeroLong);
		    	
		    	
				IngresoDespachoDto ingDes = completarDatosBasicos(d);
				
				String jsonSend = objectMapper.writeValueAsString(ingDes);
			    req.setRequest(jsonSend);
				try {
					    
					    Object resp=	port.ingresoDespacho(username,
					    		password, 
					    		ingDes.getNumeroDespacho(), 
					    		ingDes.getTerId(),
					    		ingDes.getNitEmpresaTppc1(), 
					    		ingDes.getClaseVehiculo(),
					    		ingDes.getNivelServicio(),
					    		ingDes.getPlaca(),
					    		ingDes.getDptoOrigenRuta(), 
					    		ingDes.getMunicipioOrigenRuta(), 
	    						ingDes.getDptoDestinoRuta(), 
	    						ingDes.getMunicipioDestinoRuta(), 
	    						ingDes.getViaRuta(), 
	    						ingDes.getFechaDespacho(), 
	    						ingDes.getHoraDespacho(), 
	    						ingDes.getMinutoDespacho(), 
	    						ingDes.getPasajerosDespacho(),
	    						ingDes.getTipoDespacho(), 
	    						ingDes.getTipoDespachoAutorizado(), 
	    						ingDes.getTipoConvenio(),
	    						ingDes.getNitEmpresaTppc2(), 
	    						ingDes.getNitEmpresaTe(), 
	    						ingDes.getTerminalesRecorridoRuta(), 
	    						ingDes.getValorTasaUso(), 
	    						ingDes.getOrigenPlaca());
					   
					    
					    
					    // Hacer el casting
				        if (resp instanceof Element ) {
				        	 //Element root = resp.getDocumentElement();
				        	 Element root = (Element) resp; // Casting
				        	
				        	 
				        	// Llamar a la función para recorrer los nodos hijos
				        	 WSResponse respWs=   traverseChildNodes(root);
				        	 if(respWs.getCode()!=null&& respWs.getCode().equals("0")) {
				        		 req.setResponse(respWs.getMessage());//recuperar respuesta de resp
							     req.setStatus("SUCCESS");
							     
								 entityListProcesed.add(d);
								 
								 logger.debug("Se procesó el despacho # "+d.getNumeroDespacho());
				        	 }else {
				        		 req.setResponse(respWs.getMessage());//recuperar respuesta de resp
							     req.setStatus(respWs.getStatus());
				        	 }
				        } else {
				        	logger.error("No fue posible mapear respuesta del web service de la superintendencia");
				        }
				        
					    
				} catch (Exception e) {
					
					logger.error("Se presento un error procesando el despacho # "+d.getNumeroDespacho());
					logger.error("Detalle error transferencia a supertransporte "+e.getMessage());
			
		            req.setResponse(e.getMessage());
			    	req.setStatus("FAILURE");
			        
					
				}
				//enviar error a tabla de control
				this.processControlService.create(req);
			}
			
			
		} catch (Exception e) {
			logger.error("Detalle Error General "+e.getStackTrace());
			
		}
		
    	return entityListProcesed.stream().map(this::toDto).toList();
    }

    
    // Método para recorrer los nodos hijos
    public static WSResponse traverseChildNodes(Node node) {
    	
    	WSResponse wsResponse =new WSResponse();
    	wsResponse.setCode("999");
    	wsResponse.setStatus("INDETERMINADO");
    	wsResponse.setCode("No fue posible recuperar la respuesta del servicio web");
        // Obtener los nodos hijos
        NodeList childNodes = node.getChildNodes();
        
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node child = childNodes.item(i);
            
            // Si el nodo es un elemento, puedes obtener sus atributos y contenido
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                Element childElement = (Element) child;
                
                //respuesta satisfactoria
                if((child.getNodeName().equals("desc_error")&&childElement.getTextContent().equals("Registro satisfactorio"))||
                (child.getNodeName().equals("cod_error")&&childElement.getTextContent().equals("0"))) {
                	wsResponse =new WSResponse();
                	wsResponse.setCode("0");
                	wsResponse.setStatus("SUCCESS");
                	wsResponse.setMessage("Registro satisfactorio");
                	 break;
                }else {
                	if(!child.getNodeName().equals("tiempo_respuesta")) {
	                	 if((child.getNodeName().equals("desc_error")&& !childElement.getTextContent().equals("Registro satisfactorio"))) {
	                		wsResponse =new WSResponse();
	                	 	wsResponse.setStatus("ERROR");
	                     	wsResponse.setMessage(childElement.getTextContent());
	                	 }
	                	 if(child.getNodeName().equals("cod_error")&& !childElement.getTextContent().equals("0")) {
	                 	  	wsResponse.setCode(childElement.getTextContent());
	                     }
	                	 if(wsResponse.getCode()!=null &&!wsResponse.getCode().equals("999")) {
	                		 break;
	                	 }
                	}
                }
                
                // Imprimir atributos
                /*NamedNodeMap attrs = childElement.getAttributes();
                for (int j = 0; j < attrs.getLength(); j++) {
                    Node attr = attrs.item(j);
                    System.out.println(" - Atributo: " + attr.getNodeName() + ", Valor: " + attr.getNodeValue());
                }*/
            }
        }
        return wsResponse;
    }
    
    private  IngresoDespachoDto completarDatosBasicos(EntryDispatchEntity d ) {
    	IngresoDespachoDto ingDes = null;
    	String fechaDespacho=d.getFechaDespacho()==null||d.getFechaDespacho().equals("")?"01/01/1900":d.getFechaDespacho();
		String[] partes = fechaDespacho.split(" ");
	
		 
        
        SimpleDateFormat formatoOriginal = new SimpleDateFormat("yyyy-MM-dd");
        // Crear un formato de fecha para la salida
        SimpleDateFormat formatoDeseado = new SimpleDateFormat("dd/MM/yyyy");

        try {
            // Parsear la fecha original
            Date fecha = formatoOriginal.parse(partes[0]);
            // Formatear la fecha en el nuevo formato
            fechaDespacho = formatoDeseado.format(fecha);

            
            ingDes = new IngresoDespachoDto();
   		 		 ingDes.setNumeroDespacho(d.getNumeroDespacho());
   				 ingDes.setTerId(d.getTerId());
   			     ingDes.setNitEmpresaTppc1(d.getNitEmpresaTppc1());
   			     ingDes.setClaseVehiculo(d.getClaseVehiculo());
   			     ingDes.setNivelServicio(d.getNivelServicio());
   			     ingDes.setPlaca(d.getPlaca());
   			     ingDes.setDptoOrigenRuta(d.getDptoOrigenRuta()==null||d.getDptoOrigenRuta().equals("")?"54":d.getDptoOrigenRuta());
   			     ingDes.setMunicipioOrigenRuta(d.getMunicipioOrigenRuta()==null||d.getMunicipioOrigenRuta().equals("")?"54001000":d.getMunicipioOrigenRuta());
   			     ingDes.setDptoDestinoRuta(d.getDptoDestinoRuta());
   			     ingDes.setMunicipioDestinoRuta(d.getMunicipioDestinoRuta());
   			     ingDes.setViaRuta(d.getViaRuta());
   			     ingDes.setFechaDespacho(fechaDespacho);
   			     //ingDes.setFechaDespacho("2024-09-04");
   			     ingDes.setHoraDespacho(d.getHoraDespacho()==null||d.getHoraDespacho().equals("")?"0":d.getHoraDespacho());
   			     ingDes.setMinutoDespacho(d.getMinutoDespacho()==null||d.getMinutoDespacho().equals("")?"0":d.getMinutoDespacho());
   			     ingDes.setPasajerosDespacho(d.getPasajerosDespacho());
   			     ingDes.setTipoDespacho(d.getTipoDespacho());
   			     ingDes.setTipoDespachoAutorizado(d.getTipoDespachoAutorizado());
   			     ingDes.setTipoConvenio(d.getTipoConvenio()==null||d.getTipoConvenio().equals("")?"":d.getTipoConvenio());
   			     ingDes.setNitEmpresaTppc2(d.getNitEmpresaTppc2()==null||d.getNitEmpresaTppc2().equals("")?"0":d.getNitEmpresaTppc2());
   			     ingDes.setNitEmpresaTe(d.getNitEmpresaTe()==null||d.getNitEmpresaTe().equals("")?new BigInteger("0"):new BigInteger(d.getNitEmpresaTe()));
   			     ingDes.setTerminalesRecorridoRuta(d.getTerminalesRecorridoRuta());
   			     ingDes.setValorTasaUso(d.getValorTasaUso());
   			     ingDes.setOrigenPlaca(d.getOrigenPlaca());
        } catch (ParseException e) {
        	logger.error("Error de conversión de fecha despacho " + e.getMessage());
        	
        }
        
    	
    	return ingDes;
    }
    
    public static Long convertirStringAPunto(String str) {
        try {
            // Remover el punto decimal
        	String[] partes = str.split("\\."); // Usa doble barra invertida para escapar el punto
            // Tomar solo la parte entera y convertir a Long
            return Long.parseLong(partes[0]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return null; // Retornar null en caso de error
        }
    }
    
    private EntryDispatchEntity toEntity(EntryDispatchRequest request) {
        return new ModelMapper().map(request, EntryDispatchEntity.class);
    }

    private EntryDispatchResponse toDto(EntryDispatchEntity entity) {
        return new ModelMapper().map(entity, EntryDispatchResponse.class);
    }
    
    
}