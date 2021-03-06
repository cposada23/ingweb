package com.edu.udea.iw.dao;

import java.util.List;
/**
 * @author Andersson Villa
 */

import com.edu.udea.iw.dto.Dispositivo;
import com.edu.udea.iw.dto.Reserva;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;

public interface ReservaDao {
	/** Obtiene todos las Reservas de la base de datos
	 * 
	 * @return
	 * @throws MyDaoExeption
	 */
	public List<Reserva> obtener() throws MyDaoExeption;
	
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
	public Reserva obtenerReserva(int id)throws MyDaoExeption;
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
	
	/**
	 * retorna las reservas que no han sido aprovadas
	 * @return
	 * @throws MyDaoExeption
	 */
	public List<Reserva> obtenerReservasNoAprobadas() throws MyDaoExeption;
	
	/**
	 * Obtenemos una reserva dado el usuario
	 * @param usuario
	 * @return
	 * @throws MyDaoExeption
	 */
	public List<Reserva> ObtenerReservaPorUsuario(Usuario usuario) throws MyDaoExeption;
	
	
	public List<Reserva> obtenerReservasDeDispositivos(Dispositivo dis)throws MyDaoExeption;

}
