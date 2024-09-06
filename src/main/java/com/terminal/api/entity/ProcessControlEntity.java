package com.terminal.api.entity;


/**
 * 
 * @author Franklin Pinto
 * @Project Gestión en Terminales
 * @Date 22/08/2024
 * @version 1.0.0
 */


import java.util.Date;

import javax.persistence.Column;
//import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.cache.annotation.Cacheable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
//@Entity
@Table(name = "ProcessControl")
@AllArgsConstructor
@Getter
@Setter
@Cacheable
public class ProcessControlEntity  implements java.io.Serializable {

	    /**
		 * 
		 */
		private static final long serialVersionUID = -4050885068713886977L;
		
				
		

		public ProcessControlEntity(Long id, Long nConduce, String request, String response, String status) {
			super();
			this.id = id;
			this.nConduce = nConduce;
			this.request = request;
			this.response = response;
			this.status = status;
		}

		@Id
	    @Column(name = "id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
		
		@Column(name = "nConduce")
	    private Long nConduce;
		
	    @Column(name = "request")
	    private String request;
	    
	    @Column(name = "response")
	    private String response;
	    
	    @Column(name = "status")
	    private String status;
	    
	    @Column(name = "datetime", nullable = false)
	    private Date datetime;

	       
	    
	    
		public Long getnConduce() {
			return nConduce;
		}

		public void setnConduce(Long nConduce) {
			this.nConduce = nConduce;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getRequest() {
			return request;
		}

		public void setRequest(String request) {
			this.request = request;
		}

		public String getResponse() {
			return response;
		}

		public void setResponse(String response) {
			this.response = response;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Date getDatetime() {
			return datetime;
		}

		public void setDatetime(Date datetime) {
			this.datetime = datetime;
		}
	    
	  
	   
	}