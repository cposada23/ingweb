package com.edu.udea.iw.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * Clase dto para el acceso a la tabla de dispositivo
 * @author Camilo Posada Angel - cposadaa@gmail.com
 */

@XmlRootElement
public class Dispositivo {

	private int codigo;
	private String descripcion;
	private boolean estado;
	private boolean eliminado;
	private Usuario usuarioCrea;
	private Usuario usuarioElimina;
	private Date fechaCrea;
	private Date fechaElimina;
	private Tipo tipo;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public boolean isEliminado() {
		return eliminado;
	}
	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
	public Usuario getUsuarioCrea() {
		return usuarioCrea;
	}
	public void setUsuarioCrea(Usuario usuarioCrea) {
		this.usuarioCrea = usuarioCrea;
	}
	public Usuario getUsuarioElimina() {
		return usuarioElimina;
	}
	public void setUsuarioElimina(Usuario usuarioElimina) {
		this.usuarioElimina = usuarioElimina;
	}
	public Date getFechaCrea() {
		return fechaCrea;
	}
	public void setFechaCrea(Date fechaCrea) {
		this.fechaCrea = fechaCrea;
	}
	public Date getFechaElimina() {
		return fechaElimina;
	}
	public void setFechaElimina(Date fechaElimina) {
		this.fechaElimina = fechaElimina;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	
	
}
