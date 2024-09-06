package com.terminal.api.business;

import java.math.BigInteger;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.terminal.api.client.EntryDispatchRequest;
import com.terminal.api.client.EntryDispatchResponse;
import com.terminal.api.client.TerminalesSuperTransporte;
import com.terminal.api.client.TerminalesSuperTransportePortType;
import com.terminal.api.dao.IDispatchDao;
import com.terminal.api.entity.EntryDispatchEntity;
import com.terminal.api.model.ProcessControlRequest;
import com.terminal.api.service.DispatchService;
import com.terminal.api.service.ProcessControlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Franklin Pinto
 * @Project Gestion en Terminales
 * @Date 22/08/2024
 * @version 1.0.0
 */

@Service
public class DispatchBusiness implements DispatchService {
	@Autowired
	IDispatchDao dispatchDao;
	
	@Autowired
	ProcessControlService processControlService;
	
	// Crear un logger para esta clase
    private static final Logger logger = LoggerFactory.getLogger(DispatchBusiness.class);

	 
    public List<EntryDispatchResponse> retrieve(){
    	
    	List<EntryDispatchEntity> entityList =dispatchDao.retrieve();
        
    	logger.info("** INICIANDO PROCESO TRASFERENCIA DATOS A SUPERTRANSPORTE **");
    	
    	try {
			TerminalesSuperTransportePortType iTerminal = null;
			
			
			TerminalesSuperTransporte service = new TerminalesSuperTransporte();

			
			TerminalesSuperTransportePortType port = service.getTerminalesSuperTransportePort();
			
			ProcessControlRequest req = new ProcessControlRequest();
			 ObjectMapper objectMapper = new ObjectMapper();
			 String json ="";
			/*
			String res=port.ingresoDespacho("830509855",
					"830509855", 
					"6781721", 
					new BigInteger("15"),
					"800152028", 
					new BigInteger("7"),
					new BigInteger("1"),
					"WLS933"
					,"54",
					"54001000",
					"54", 
					"54001000", 
					"NO ESPECIFICA", 
					"10/08/2024", 
					"5",
					"6", 
					new BigInteger("4"),
					new BigInteger("1"), 
					new BigInteger("1"), 
					null, null, null, 
					new BigInteger("2"), 
					new BigInteger("17700"), 
				new BigInteger("0"));
			*/
			
			for (EntryDispatchEntity d : entityList) {
				
				json = objectMapper.writeValueAsString(d);
				
				req.setnConduce(Long.valueOf(d.getNumeroDespacho()));
		    	req.setRequest(json);
		    	
				try {
					
			    	
					    String resp=	port.ingresoDespacho("830509855",
						"830509855", 
						d.getNumeroDespacho(), 
						d.getTerId(),
						d.getNitEmpresaTppc1(), 
						d.getClaseVehiculo(),
						d.getNivelServicio(),
						d.getPlaca(),
						d.getDptoOrigenRuta()==null?"54":d.getDptoOrigenRuta(), 
						d.getMunicipioOrigenRuta()==null?"54001000":d.getMunicipioOrigenRuta(), 
						d.getDptoDestinoRuta(), 
						d.getMunicipioDestinoRuta(), 
						d.getViaRuta(), 
						d.getFechaDespacho()==null?"04/09/2024":d.getFechaDespacho(), 
						d.getHoraDespacho()==null?"9":d.getHoraDespacho(), 
						d.getMinutoDespacho()==null?"25":d.getMinutoDespacho(), 
						d.getPasajerosDespacho(),
						d.getTipoDespacho(), 
						d.getTipoDespachoAutorizado(), 
						d.getTipoConvenio()==null?new BigInteger("1"):new BigInteger(d.getTipoConvenio()),
						d.getNitEmpresaTppc2()==null?new BigInteger("123456789"):new BigInteger(d.getNitEmpresaTppc2()), 
					    d.getNitEmpresaTe()==null?new BigInteger("0"):new BigInteger(d.getNitEmpresaTe()), 
						d.getTerminalesRecorridoRuta(), 
						d.getValorTasaUso(), 
						d.getOrigenPlaca());
					    
					    req.setResponse(resp);
					    req.setStatus("SUCCESS");
					    System.out.println("Respuesta invocacion servicio "+resp);
					    
					  
				        logger.debug("Se procesó el despacho # "+d.getNumeroDespacho());
				      
					    
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
			logger.trace("Detalle Error General "+e.getStackTrace());
			
		}
		
    	return entityList.stream().map(this::toDto).toList();
    }

    private EntryDispatchEntity toEntity(EntryDispatchRequest request) {
        return new ModelMapper().map(request, EntryDispatchEntity.class);
    }

    private EntryDispatchResponse toDto(EntryDispatchEntity entity) {
        return new ModelMapper().map(entity, EntryDispatchResponse.class);
    }
    
    
}