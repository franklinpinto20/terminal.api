package com.terminal.api.service;

import java.util.List;

import com.terminal.api.model.ProcessControlRequest;
import com.terminal.api.model.ProcessControlResponse;



/**
 * @author Franklin Pinto
 * @Project Gestión en Terminales
 * @Date 22/08/2024
 * @version 1.0.0
 */
public interface ProcessControlService {
	
	
	
	/**
	 * 
	 * @return
	*/ 

	void create(ProcessControlRequest req);
	
	void update(Long id, ProcessControlRequest req);
	
	ProcessControlResponse getById(Long id);
	ProcessControlResponse getByNconduce(Long id);
	
	List<ProcessControlResponse> getAll();
	
}
