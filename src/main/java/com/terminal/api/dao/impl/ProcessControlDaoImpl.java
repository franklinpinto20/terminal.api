package com.terminal.api.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.terminal.api.business.DispatchBusiness;
import com.terminal.api.dao.IProcessControlDao;
import com.terminal.api.entity.ProcessControlEntity;

/**
 * 
 * @author Franklin Pinto
 * @Project Gestión en Terminales
 * @Date 22/08/2024
 * @version 1.0.0
 */

@Service
public class ProcessControlDaoImpl implements IProcessControlDao {

	 @Autowired
	 private JdbcTemplate template;
	 
	// Crear un logger para esta clase
	 private static final Logger logger = LoggerFactory.getLogger(ProcessControlDaoImpl.class);

	@Override
	public void create(ProcessControlEntity entity) {
		try {
			
				String sql = "INSERT INTO public.ProcessControl (Nconduce, Request, Response, Status, ProcessDate) VALUES (?,?,?,?,?)";
		
			    // Ejecutar el insert con los parámetros proporcionados
				template.update(sql, entity.getnConduce(), entity.getRequest(), entity.getResponse(),entity.getStatus(), new Date());
		
				logger.info("Proceso insertado correctamente: " + entity.getnConduce());
		}catch (Exception e) {
				logger.error("Se ha producido un error en Base de datos creando el proceso: "+e.getMessage());
		}
	}

	@Override
	public void update(ProcessControlEntity entity, Long id) {
		String sql = "UPDATE ProcessControl SET Nconduce = ?,Request = ?, Response = ?, Status = ? WHERE ID = ?";
        
				// Ejecutar la actualización con los parámetros proporcionados
		        int rowsAffected = template.update(sql, entity.getnConduce(),entity.getRequest(), entity.getResponse(), entity.getStatus(), id);

		        if (rowsAffected > 0) {
		        	logger.info("ProcessControlEntity actualizado correctamente: ID " + id);
		        } else {
		        	logger.info("No se encontró el ProcessControlEntity con ID: " + id);
		        }
		
	}

	@Override	
	public Optional<ProcessControlEntity> findById(Long id) {
		ProcessControlEntity country = template.queryForObject("SELECT * FROM ProcessControl WHERE id = ?",
	            (rs, rowNum) -> mapToProcessControl(rs), id);
	    return Optional.ofNullable(country);
	}
	
	private ProcessControlEntity mapToProcessControl(ResultSet rs) throws SQLException {
        return new ProcessControlEntity(
        		rs.getLong("ID"),
            	rs.getLong("nconduce"),
            	rs.getString("request"),
            	rs.getString("response"),
            	rs.getString("status")
                );
   }
	@Override
	public Optional<ProcessControlEntity> findByNconduce(Long id) {
		ProcessControlEntity country = template.queryForObject("SELECT * FROM ProcessControl WHERE nconduce = ?",
	            (rs, rowNum) -> mapToProcessControl(rs), id);
	    return Optional.ofNullable(country);
	}
	
	
	@Override
	public List<ProcessControlEntity> getAll() {

    	return  template.query("SELECT * FROM public.ProcessControl", new RowMapper<ProcessControlEntity>() {
    		
             @Override
             public ProcessControlEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
                 return new ProcessControlEntity(rs.getLong("id"),rs.getLong("nconduce"), rs.getString("request"),rs.getString("response"), rs.getString("status"));
            	 
             }
         });
    	
    }

}