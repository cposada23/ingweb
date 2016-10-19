package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Dispositivo;
import com.edu.udea.iw.exeption.MyDaoExeption;

public interface DispositivoDao {
	
	
	/**
	 * Obtener todos los dispositivos registrados en la base de datos
	 * @return
	 * @throws MyDaoExeption
	 */
	public List<Dispositivo> getDispositivos() throws MyDaoExeption;

}
