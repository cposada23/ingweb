package com.edu.udea.iw.logicaNegocio;

import java.util.Date;
import java.util.List;

import com.edu.udea.iw.dto.Reserva;
import com.edu.udea.iw.exeption.MyDaoExeption;
/**
 * Interface de Reserva para la logica del negocio
 * @author Camilo Posada Angel - cposadaa@gmail.com
 */
public interface ReservaBL {

	/**
	 * Valida la realizacion de una reserva segun la logica del negocio
	 * @param usuarioReserva
	 * @param dispositivo
	 * @throws MyDaoExeption
	 */
	public void realizarReserva(String usuarioReserva, int dispositivo) throws MyDaoExeption;
	
	
	
	public void realizarReserva2(String usuarioReserva, int dispositivo, Date fechaInicio) throws MyDaoExeption;
	
	/**
	 * Aprobar una reserva segun la logica del negocio
	 * @param usuarioAprueba
	 * @param reserva
	 * @throws MyDaoExeption
	 */
	public void aprobarReserva(String usuarioAprueba, Reserva reserva) throws MyDaoExeption;
	
	/**
	 * Obtener todas las reservas de un usuario
	 * @param usuarioReserva
	 * @return Lista de reservas del usuario 
	 * @throws MyDaoExeption en caso de que el usuaio no exista o no tenga reservas 
	 */
	public List<Reserva> misReservas(String usuarioReserva) throws MyDaoExeption;
	
	
}
