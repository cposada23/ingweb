package com.edu.udea.iw.logicaNegocio;

import java.util.List;

import com.edu.udea.iw.dto.Prestamo;
import com.edu.udea.iw.exeption.MyDaoExeption;

public interface PrestamoBL {

	/**
	 * crea un nuevo prestamo en la bd
	 * @param usuarioPresta
	 * @param usuarioAprueba
	 * @param dispositivo
	 * @throws MyDaoExeption
	 */
	public void crearPrestamo(String usuarioPresta, String usuarioAprueba, int dispositivo) throws MyDaoExeption;
	
	
	/**
	 * Busca los prestamos de un usuario
	 * @param usuarioPresta
	 * @return
	 * @throws MyDaoExeption
	 */
	public List<Prestamo> buscarPrestamos(String usuarioPresta) throws MyDaoExeption;
	
}
