package com.edu.udea.iw.logicaNegocio;

import com.edu.udea.iw.dto.Prestamo;
import com.edu.udea.iw.exeption.MyDaoExeption;

public interface PrestamoBL {

	
	public void crearPrestamo(String usuarioPresta, String usuarioAprueba, int dispositivo) throws MyDaoExeption;
	
	public Prestamo buscarPrestamo(String usuarioPresta) throws MyDaoExeption;
	
}
