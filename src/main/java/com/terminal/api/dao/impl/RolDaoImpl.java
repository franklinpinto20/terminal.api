package com.terminal.api.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.terminal.api.dao.IRolDao;
import com.terminal.api.entity.RolEntity;

/**
 * 
 * @author Franklin Pinto
 * @Project Gestión en Terminales
 * @Date 22/08/2024
 * @version 1.0.0
 */


@Service
public class RolDaoImpl implements IRolDao {

	 @Autowired
	    private JdbcTemplate template;
	 
    public List<RolEntity> retrieve(){
    	
    	return  template.query("SELECT * FROM public.rol", new RowMapper<RolEntity>() {
    	
             @Override
             public RolEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
                 return new RolEntity(rs.getLong("id_rol"), rs.getString("rol"), rs.getString("descripcion"));
            	 
             }
         });
    	
    }

   
}