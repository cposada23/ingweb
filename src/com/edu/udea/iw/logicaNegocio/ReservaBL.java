package com.edu.udea.iw.logicaNegocio;

import com.edu.udea.iw.dto.Reserva;
import com.edu.udea.iw.exeption.MyDaoExeption;

public interface ReservaBL {

	/**
	 * Valida la realizacion de una reserva segun la logica del negocio
	 * @param usuarioReserva
	 * @param dispositivo
	 * @throws MyDaoExeption
	 */
	public void realizarReserva(String usuarioReserva, int dispositivo) throws MyDaoExeption;
	
	/**
	 * Aprobar una reserva segun la logica del negocio
	 * @param usuarioAprueba
	 * @param reserva
	 * @throws MyDaoExeption
	 */
	public void aprobarReserva(String usuarioAprueba, Reserva reserva) throws MyDaoExeption;
	
	
}
