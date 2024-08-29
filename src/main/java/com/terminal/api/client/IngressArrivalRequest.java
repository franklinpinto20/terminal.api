package com.terminal.api.client;

import java.math.BigInteger;

import javax.jws.WebParam;

public class IngressArrivalRequest {

	
	
	private String usuario;
    
	private String clave;
   
	private BigInteger terId;
    
	private String nitEmpresaTppc;
  
	private String placa;
  
	private BigInteger tipoLlegada;
   
	private String fechaLlegada;
   
	private String horaLlegada;
  
	private String minutoLlegada;
   
	private BigInteger pasajerosLlegada;
  
	private String dptoOrigenRuta;
   
	private String municipioOrigenRuta;
   
	private String dptoDestinoRuta;
  
	private String municipioDestinoRuta;

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

	public BigInteger getTerId() {
		return terId;
	}

	public void setTerId(BigInteger terId) {
		this.terId = terId;
	}

	public String getNitEmpresaTppc() {
		return nitEmpresaTppc;
	}

	public void setNitEmpresaTppc(String nitEmpresaTppc) {
		this.nitEmpresaTppc = nitEmpresaTppc;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public BigInteger getTipoLlegada() {
		return tipoLlegada;
	}

	public void setTipoLlegada(BigInteger tipoLlegada) {
		this.tipoLlegada = tipoLlegada;
	}

	public String getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(String fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public String getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public String getMinutoLlegada() {
		return minutoLlegada;
	}

	public void setMinutoLlegada(String minutoLlegada) {
		this.minutoLlegada = minutoLlegada;
	}

	public BigInteger getPasajerosLlegada() {
		return pasajerosLlegada;
	}

	public void setPasajerosLlegada(BigInteger pasajerosLlegada) {
		this.pasajerosLlegada = pasajerosLlegada;
	}

	public String getDptoOrigenRuta() {
		return dptoOrigenRuta;
	}

	public void setDptoOrigenRuta(String dptoOrigenRuta) {
		this.dptoOrigenRuta = dptoOrigenRuta;
	}

	public String getMunicipioOrigenRuta() {
		return municipioOrigenRuta;
	}

	public void setMunicipioOrigenRuta(String municipioOrigenRuta) {
		this.municipioOrigenRuta = municipioOrigenRuta;
	}

	public String getDptoDestinoRuta() {
		return dptoDestinoRuta;
	}

	public void setDptoDestinoRuta(String dptoDestinoRuta) {
		this.dptoDestinoRuta = dptoDestinoRuta;
	}

	public String getMunicipioDestinoRuta() {
		return municipioDestinoRuta;
	}

	public void setMunicipioDestinoRuta(String municipioDestinoRuta) {
		this.municipioDestinoRuta = municipioDestinoRuta;
	}
	
	
	
	
}
