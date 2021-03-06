package com.edu.udea.iw.dto;


/**
 * dto para el acceso a la tabla de Reserva
 * @author Andersson Villa 
 */

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Reserva {
	private int codigo;
	private Usuario usuarioReserva;
	private Usuario UsuarioAprueba;
	private Date FechaReserva;
	private Date vence;
	private Dispositivo dispositivo;
	private boolean aprobado;	
	

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFechaReserva() {
		return FechaReserva;
	}
	public void setFechaReserva(Date fechaReserva) {
		FechaReserva = fechaReserva;
	}
	public Date getVence() {
		return vence;
	}
	public void setVence(Date vence) {
		this.vence = vence;
	}
	public Usuario getUsuarioReserva() {
		return usuarioReserva;
	}
	public void setUsuarioReserva(Usuario usuarioReserva) {
		this.usuarioReserva = usuarioReserva;
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
	
	public boolean getAprobado() {
		return aprobado;
	}
	public void setAprobado(boolean aprobado) {
		this.aprobado = aprobado;
	}

	
	


}
