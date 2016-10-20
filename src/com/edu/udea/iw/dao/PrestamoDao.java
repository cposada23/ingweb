package com.edu.udea.iw.dao;

/**
 * @author Andersson Villa
 */


import java.util.List;

import com.edu.udea.iw.dto.Prestamo;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;

public interface PrestamoDao {
	/** Obtiene todos los prestamos de la base de datos
	 * 
	 * @return
	 * @throws MyDaoExeption
	 */
	public List<Prestamo> obtener() throws MyDaoExeption;
	
	
	/**
	 * guarda un nuevo prestamo en la bd
	 * @param prestamo
	 * @throws MyDaoExeption
	 */
	public void guardar(Prestamo prestamo) throws MyDaoExeption;
	
	/**
	 * Obtiene un prestamo dado su codigo
	 * @param codigo
	 * @return
	 * @throws MyDaoExeption
	 */
	public Prestamo obtenerPorCodigo(int codigo) throws MyDaoExeption;

	/**
	 * Obtiene una lista de prestamos de un investigador
	 * @param usuario
	 * @return
	 * @throws MyDaoExeption
	 */
	public List<Prestamo> obtenerPrestamosUsuario(Usuario usuario) throws MyDaoExeption;
}
