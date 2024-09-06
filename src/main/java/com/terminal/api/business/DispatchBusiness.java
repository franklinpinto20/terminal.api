package com.terminal.api.business;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.terminal.api.client.EntryDispatchRequest;
import com.terminal.api.client.EntryDispatchResponse;
import com.terminal.api.client.TerminalesSuperTransporte;
import com.terminal.api.client.TerminalesSuperTransportePortType;
import com.terminal.api.dao.IDispatchDao;
import com.terminal.api.entity.EntryDispatchEntity;
import com.terminal.api.entity.RolEntity;
import com.terminal.api.model.RolResponse;
import com.terminal.api.repository.RolRepository;
import com.terminal.api.service.DispatchService;
import com.terminal.api.service.RolService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class DispatchBusiness implements DispatchService {
	@Autowired
	IDispatchDao dispatchDao;
	
	 
    public List<EntryDispatchResponse> retrieve(){
    	
    	List<EntryDispatchEntity> entityList =dispatchDao.retrieve();
        
    	
    	
    	try {
			TerminalesSuperTransportePortType iTerminal = null;
			
			
			TerminalesSuperTransporte service = new TerminalesSuperTransporte();

			
			TerminalesSuperTransportePortType port = service.getTerminalesSuperTransportePort();
			
			
		
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
						new BigInteger("0"),//d.getTipoConvenio(),
						new BigInteger("0"),//d.getNitEmpresaTppc2(), 
						new BigInteger("0"),//d.getNitEmpresaTe(), 
						d.getTerminalesRecorridoRuta(), 
						d.getValorTasaUso(), 
						d.getOrigenPlaca());
					    System.out.println("Respuesta invocacion servicio "+resp);
				} catch (Exception e) {
					
					 System.err.println("Error invocando el servicio: " + e.getMessage());
					//enviar error a tabla de control
					
				}
			}
			
			//List<EntryDispatchRequest> lst= new ArrayList<>();
			
			
			//System.out.println("Respuesa a"+res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
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