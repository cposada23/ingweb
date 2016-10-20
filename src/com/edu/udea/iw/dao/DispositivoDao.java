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
	
	
	/**
	 * Crea un nuevo dispositivo en la base de datos
	 * @param dispositivo
	 * @throws MyDaoExeption
	 */
	public void crear(Dispositivo dispositivo) throws MyDaoExeption;
	
	/**
	 * Busca un dispositivo por medio de su codigo
	 * @param codigo
	 * @return
	 * @throws MyDaoExeption
	 */

	public Dispositivo obtenerPorCodigo(int codigo) throws MyDaoExeption;

}
