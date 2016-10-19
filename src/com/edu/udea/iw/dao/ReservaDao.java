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
	public List<Reserva> obtener() throws MyDaoExeption;

}
