package com.terminal.api.dao;

import java.util.List;

import com.terminal.api.entity.RolEntity;



/**
 * 
 * @author Franklin Pinto
 * @Project Gestión en Terminales
 * @Date 22/08/2024
 * @version 1.0.0
 */
public interface IRolDao {
	
	
	
	/**
	 * 
	 * @return
	*/ 

	List<RolEntity> retrieve();
	
}
