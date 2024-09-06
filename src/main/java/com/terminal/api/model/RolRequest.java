package com.terminal.api.model;

import lombok.Data;
/**
 * 
 * @author Franklin Pinto	
 * @Project Information Panel Management
 * @mineduacion
 * @Date 22/08/2024
 * @version 1.0.0
 */
@Data
public class RolRequest {
    private Long idRol;
    private String rol;
    private String descripcion;
    public RolRequest() {
    	
    }
    		
	public RolRequest(String string, String string2) {
		this.rol=string;
		this.descripcion=string2;
		
	}
	public Long getIdRol() {
		return idRol;
	}
	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
    

}
