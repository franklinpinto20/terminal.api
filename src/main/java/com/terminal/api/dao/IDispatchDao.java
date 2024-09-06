package com.terminal.api.dao;

import java.util.List;

import com.terminal.api.client.EntryDispatchRequest;
import com.terminal.api.client.EntryDispatchResponse;
import com.terminal.api.entity.EntryDispatchEntity;
import com.terminal.api.model.RolResponse;



/**
 * 
 * @author Franklin Pinto
 * @Project Information Panel Management
 * @Mineducacion
 * @Date 22/08/2024
 * @version 1.0.0
 */
public interface IDispatchDao {
	
	
	
	/**
	 * 
	 * @return
	*/ 
	//List<EntryDispatchEntity> retrieve();
	List<EntryDispatchEntity> retrieve();
	
}
