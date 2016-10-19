package com.edu.udea.iw.dao;

import java.util.List;
/**
 * @author Andersson Villa
 */

import com.edu.udea.iw.dto.Reserva;
import com.edu.udea.iw.exeption.MyDaoExeption;

public interface ReservaDao {
	/** Obtiene todos las Reservas de la base de datos
	 * 
	 * @return
	 * @throws MyDaoExeption
	 */
	public List<Reserva> obtenerReservas() throws MyDaoExeption;
	
	/**
	 * Se obtiene el reserva dado el id
	 * @param id
	 * @return
	 * @throws MyDaoExeption
	 */
	public Reserva obtenerPrestamo(int id)throws MyDaoExeption;
	/**
	 * se actualiza la reserva en la base de datos
	 * @param reserva
	 * @return
	 * @throws MyDaoExeption
	 */
	public void actualizarReserva(Reserva reserva)throws MyDaoExeption;
	/**
	 * se elimina de forma logica al usuario de la base de datos
	 * @param reserva
	 * @return
	 * @throws MyDaoExeption
	 */
	public void eliminarReserva(Reserva reserva) throws MyDaoExeption;
	/**
	 * se crea el usuario en la base de datos
	 * @param reserva
	 * @return
	 * @throws MyDaoExeption
	 */
	public void crearReserva(Reserva reserva)throws MyDaoExeption;

}
