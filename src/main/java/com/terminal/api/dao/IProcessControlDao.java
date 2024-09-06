package com.terminal.api.dao;

import java.util.List;
import java.util.Optional;

import com.terminal.api.entity.ProcessControlEntity;



/**
 * 
 * @author Franklin Pinto
 * @Project Gestión en Terminales
 * @Date 22/08/2024
 * @version 1.0.0
 */
public interface IProcessControlDao {
	
	
	
	/**
	 * 
	 * @return
	*/ 

	void create(ProcessControlEntity entity);
	
	void update(ProcessControlEntity entity, Long id);
	
	public Optional<ProcessControlEntity> findById(Long id);
	
	public Optional<ProcessControlEntity> findByNconduce(Long id);
	
	public List<ProcessControlEntity> getAll();
	
}
