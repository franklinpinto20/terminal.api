package com.terminal.api.business;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.terminal.api.entity.Rol;
import com.terminal.api.model.RolResponse;
import com.terminal.api.repository.RolRepository;
import com.terminal.api.service.RolService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class RolBusiness implements RolService {
	/*@Autowired
	RolRepository rolRepository;*/
	 @Autowired
	    private JdbcTemplate template;
	 
    public List<RolResponse> retrieve(){
    	
    	//Object a =rolRepository.findAll();
    	
        //return rolRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
        
    	List<Rol> rolList = template.query("SELECT * FROM public.sql_FEX_Depachos_Definitivo_LRV", new RowMapper<Rol>() {
    	
             @Override
             public Rol mapRow(ResultSet rs, int rowNum) throws SQLException {
                // return new Rol(rs.getLong("id_rol"), rs.getString("rol"), rs.getString("descripcion"));
            	 return new Rol(rs.getString("Placa"), rs.getString("Num_pasajeros"), rs.getString("Nombre_empresa"));
             }
         });
    	
    	return rolList.stream().map(this::toDto).collect(Collectors.toList());
    }

  /*  private Rol toEntity(RolRequest request) {
        return new ModelMapper().map(request, Rol.class);
    }
*/
    private RolResponse toDto(Rol entity) {
        return new ModelMapper().map(entity, RolResponse.class);
    }
}