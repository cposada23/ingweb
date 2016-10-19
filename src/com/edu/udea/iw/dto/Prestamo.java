
package com.edu.udea.iw.dto;


/**
 * dto para el acceso a la tabla de prestamos
 * @author Andersson Villa 
 */

import java.util.Date;

public class Prestamo {
	private int codigo;
	private Usuario usuarioPresta;
	private Usuario UsuarioAprueba;
	private Date FechaInicio;
	private Date FechaFin;
	private Dispositivo dispositivo;
	
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFechaInicio() {
		return FechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		FechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return FechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		FechaFin = fechaFin;
	}

	public Usuario getUsuarioPresta() {
		return usuarioPresta;
	}
	public void setUsuarioPresta(Usuario usuarioPresta) {
		this.usuarioPresta = usuarioPresta;
	}
	public Usuario getUsuarioAprueba() {
		return UsuarioAprueba;
	}
	public void setUsuarioAprueba(Usuario usuarioAprueba) {
		UsuarioAprueba = usuarioAprueba;
	}
	public Dispositivo getDispositivo() {
		return dispositivo;
	}
	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}
	
	

}

