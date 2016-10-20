package com.edu.udea.iw.logicaNegocio;

import com.edu.udea.iw.dto.Reserva;
import com.edu.udea.iw.exeption.MyDaoExeption;

public interface PrestamoBL {
	
	/**
	 * creamos un prestamo dados los siguientes parametros
	 * @param UsuarioPresta
	 * @param UsuarioAprueba
	 * @param Dispositivo
	 * @throws MyDaoExeption
	 */
	public void crearPrestamo(String usuarioPresta,String usuarioAprueba,int dispositivo) throws MyDaoExeption;
	
	/**
	 * Creamos un prestamo dada la reserva
	 * @param reserva
	 * @throws MyDaoExeption
	 */
	public void crearPrestamo(Reserva reserva)throws MyDaoExeption;
	
	public void buscarPrestamo(String usuarioPresta) throws MyDaoExeption;

	

}


/**
realizar reserva
aprovarreserva
realizarpresttamo
*/