package com.terminal.api.entity;




/*import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;*/


import org.springframework.data.relational.core.mapping.Column;
//import org.springframework.data.relational.core.mapping.Entity;
//import org.springframework.data.relational.core.mapping.GeneratedValue;
//import org.springframework.data.relational.core.mapping.GenerationType;
//import org.springframework.data.relational.core.mapping.Id;
import org.springframework.data.relational.core.mapping.Table;


import org.springframework.cache.annotation.Cacheable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

	@NoArgsConstructor
	//@Entity
	@Table(name = "rol")
	@AllArgsConstructor
	@Getter
	@Setter
	@Cacheable
	public class RolEntity  implements java.io.Serializable {

	    /**
		 * 
		 */
		private static final long serialVersionUID = -4050885068713886977L;
		//@Id
	   // @Column(name = "id_rol")
	   // @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idRol;
	    //@Column(name = "rol")
	    private String rol;
	    private String placa;
	    //@Column(name = "descripcion")
	    private String descripcion;
	    
	   // private String flush;
		public RolEntity(Long int1, String string, String string2) {
			// TODO Auto-generated constructor stub
			this.idRol=int1;
			this.rol=string;
			this.descripcion=string2;
		}
		public RolEntity(String int1, String string, String string2) {
			// TODO Auto-generated constructor stub
			this.placa=int1;
			this.rol=string;
			this.descripcion=string2;
		}
		public Long getId_rol() {
			return idRol;
		}
		public void setId_rol(Long id_rol) {
			this.idRol = id_rol;
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
		public Long getIdRol() {
			return idRol;
		}
		public void setIdRol(Long idRol) {
			this.idRol = idRol;
		}
		
		/*
		public String getFlush() {
			return flush;
		}
		public void setFlush(String flush) {
			this.flush = flush;
		}*/

	   
	}