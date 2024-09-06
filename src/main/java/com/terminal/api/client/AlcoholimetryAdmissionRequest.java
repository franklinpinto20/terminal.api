package com.terminal.api.client;

import java.math.BigInteger;


/**
 * 
 * @author Franklin Pinto
 * @Project Gestión en Terminales
 * @Date 22/08/2024
 * @version 1.0.0
 */

public class AlcoholimetryAdmissionRequest {

	
	 
      private String usuario;
    
      String clave;
      
      private String numeroDespacho;
    
      private  String nitOperador;
      
      private  String razonSocialOperador;
     
      private  String terId;
     
      private  BigInteger tipoDocumentoConductor;
   
      private String numeroDocumentoConductor;
     
      private String nombreConductor;
    
      private  String fechaPrueba;
    
      private String horaPrueba;
     
      private String minutoPrueba;
    
      private BigInteger resultadosPrueba;
      
      private BigInteger gradoAlcoholemia;
     
      private BigInteger examenMedico;
     
      private String horaExamen;
     
      private String minutoExamen;
      
      private  BigInteger resultadoExamen;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNumeroDespacho() {
		return numeroDespacho;
	}

	public void setNumeroDespacho(String numeroDespacho) {
		this.numeroDespacho = numeroDespacho;
	}

	public String getNitOperador() {
		return nitOperador;
	}

	public void setNitOperador(String nitOperador) {
		this.nitOperador = nitOperador;
	}

	public String getRazonSocialOperador() {
		return razonSocialOperador;
	}

	public void setRazonSocialOperador(String razonSocialOperador) {
		this.razonSocialOperador = razonSocialOperador;
	}

	public String getTerId() {
		return terId;
	}

	public void setTerId(String terId) {
		this.terId = terId;
	}

	public BigInteger getTipoDocumentoConductor() {
		return tipoDocumentoConductor;
	}

	public void setTipoDocumentoConductor(BigInteger tipoDocumentoConductor) {
		this.tipoDocumentoConductor = tipoDocumentoConductor;
	}

	public String getNumeroDocumentoConductor() {
		return numeroDocumentoConductor;
	}

	public void setNumeroDocumentoConductor(String numeroDocumentoConductor) {
		this.numeroDocumentoConductor = numeroDocumentoConductor;
	}

	public String getNombreConductor() {
		return nombreConductor;
	}

	public void setNombreConductor(String nombreConductor) {
		this.nombreConductor = nombreConductor;
	}

	public String getFechaPrueba() {
		return fechaPrueba;
	}

	public void setFechaPrueba(String fechaPrueba) {
		this.fechaPrueba = fechaPrueba;
	}

	public String getHoraPrueba() {
		return horaPrueba;
	}

	public void setHoraPrueba(String horaPrueba) {
		this.horaPrueba = horaPrueba;
	}

	public String getMinutoPrueba() {
		return minutoPrueba;
	}

	public void setMinutoPrueba(String minutoPrueba) {
		this.minutoPrueba = minutoPrueba;
	}

	public BigInteger getResultadosPrueba() {
		return resultadosPrueba;
	}

	public void setResultadosPrueba(BigInteger resultadosPrueba) {
		this.resultadosPrueba = resultadosPrueba;
	}

	public BigInteger getGradoAlcoholemia() {
		return gradoAlcoholemia;
	}

	public void setGradoAlcoholemia(BigInteger gradoAlcoholemia) {
		this.gradoAlcoholemia = gradoAlcoholemia;
	}

	public BigInteger getExamenMedico() {
		return examenMedico;
	}

	public void setExamenMedico(BigInteger examenMedico) {
		this.examenMedico = examenMedico;
	}

	public String getHoraExamen() {
		return horaExamen;
	}

	public void setHoraExamen(String horaExamen) {
		this.horaExamen = horaExamen;
	}

	public String getMinutoExamen() {
		return minutoExamen;
	}

	public void setMinutoExamen(String minutoExamen) {
		this.minutoExamen = minutoExamen;
	}

	public BigInteger getResultadoExamen() {
		return resultadoExamen;
	}

	public void setResultadoExamen(BigInteger resultadoExamen) {
		this.resultadoExamen = resultadoExamen;
	}
      
      
      
      
}
