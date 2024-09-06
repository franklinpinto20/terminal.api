package com.terminal.api.business;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.terminal.api.dao.IRolDao;
import com.terminal.api.entity.RolEntity;
import com.terminal.api.model.RolRequest;
import com.terminal.api.model.RolResponse;
import com.terminal.api.service.RolService;

/**
 * 
 * @author Franklin Pinto
 * @Project Gestion en Terminales
 * @Date 22/08/2024
 * @version 1.0.0
 */


@Service
public class RolBusiness implements RolService {
	
	@Autowired
	IRolDao rol;
	
	 
    public List<RolResponse> retrieve(){
    	
    	List<RolEntity> rolList = rol.retrieve();
    	
    	return rolList.stream().map(this::toDto).collect(Collectors.toList());
    }

    private RolEntity toEntity(RolRequest request) {
        return new ModelMapper().map(request, RolEntity.class);
    }

    private RolResponse toDto(RolEntity entity) {
        return new ModelMapper().map(entity, RolResponse.class);
    }
}