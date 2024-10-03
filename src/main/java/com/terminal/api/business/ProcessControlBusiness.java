package com.terminal.api.business;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.terminal.api.constant.ErrorConstant;
import com.terminal.api.dao.IProcessControlDao;
import com.terminal.api.entity.ProcessControlEntity;
import com.terminal.api.exeption.NoDataFoundException;
import com.terminal.api.model.ProcessControlRequest;
import com.terminal.api.model.ProcessControlResponse;
import com.terminal.api.service.ProcessControlService;

import lombok.AllArgsConstructor;


/**
 * 
 * @author Franklin Pinto
 * @Project Gestión en Terminales
 * @Date 22/08/2024
 * @version 1.0.0
 */


@Service
@AllArgsConstructor
public class ProcessControlBusiness implements ProcessControlService {
	@Autowired	
	private IProcessControlDao processControlDao;

	 
	 @Value("${app.process.control.activate}")
	 private Boolean processControlActivate;
    
    private ProcessControlEntity toEntity(ProcessControlRequest request) {
        return new ModelMapper().map(request, ProcessControlEntity.class);
    }

    private ProcessControlResponse toDto(ProcessControlEntity entity) {
        return new ModelMapper().map(entity, ProcessControlResponse.class);
    }
    
  
    @Override
	public void create(ProcessControlRequest req) {
		if(processControlActivate)
			processControlDao.create(toEntity(req));
		
	}


	@Override
	public void update(Long id, ProcessControlRequest req) {
		if(processControlActivate)
			processControlDao.update(toEntity(req),id);
		
	}

	@Override
	public ProcessControlResponse getById(Long id) {

		return this.processControlDao.findById(id).map(this::toDto).<NoDataFoundException>orElseThrow(() -> {
            throw new NoDataFoundException(ErrorConstant.RECORD_NOT_FOUND_MESSAGE + ": el proceso con el id proporcionado no existe");
        });
				
	}

	@Override
	public List<ProcessControlResponse> getAll() {
		
		return processControlDao.getAll().stream().map(this::toDto).toList();
	}

	@Override
	public ProcessControlResponse getByNconduce(Long id) {

		return this.processControlDao.findByNconduce(id).map(this::toDto).<NoDataFoundException>orElseThrow(() -> {
            throw new NoDataFoundException(ErrorConstant.RECORD_NOT_FOUND_MESSAGE + ": el proceso con el id proporcionado no existe");
        });
				
	}

	
}