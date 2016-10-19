package com.edu.udea.iw.dao;

/**
 * @author Andersson Villa
 */


import java.util.List;

import com.edu.udea.iw.dto.Prestamo;
import com.edu.udea.iw.exeption.MyDaoExeption;

public interface PrestamoDao {
	/** Obtiene todos los prestamos de la base de datos
	 * 
	 * @return
	 * @throws MyDaoExeption
	 */
	public List<Prestamo> obtenerPrestamos() throws MyDaoExeption;
	
	/**
	 * Obtener un prestamo dado el id
	 * @param id
	 * @return
	 * @throws MyDaoExeption
	 */
	public Prestamo obtenerPrestamo(int id) throws MyDaoExeption;
	/**
	 * Crear el prestamo en la base de datos
	 * @param prestamo
	 * @throws MyDaoExeption
	 */
	public void crearPrestamo(Prestamo prestamo) throws MyDaoExeption;
	/**
	 * Se actualiza el prestamo en la base de datos
	 * @param prestamo
	 * @return
	 * @throws MyDaoExeption
	 */
	public void actualizarPrestamo(Prestamo prestamo)throws MyDaoExeption;
	/**
	 * Se elimina de forma logica el prestamo de la base de datos
	 * @param prestamo
	 * @return
	 * @throws MyDaoExeption
	 */
	public void eliminarPrestamo(Prestamo prestamo) throws MyDaoExeption;
	

}
