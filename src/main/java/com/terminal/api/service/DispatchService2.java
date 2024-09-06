package com.terminal.api.service;

import java.util.List;

import com.terminal.api.client.EntryDispatchRequest;
import com.terminal.api.model.RolResponse;



/**
 * 
 * @author Franklin Pinto
 * @Project Information Panel Management
 * @Mineducacion
 * @Date 22/08/2024
 * @version 1.0.0
 */
public interface DispatchService2 {
	
	
	
	/**
	 * 
	 * @return
	*/ 
	//List<RolResponse> retrieve();
	List<EntryDispatchRequest> retrieve();
	
}
