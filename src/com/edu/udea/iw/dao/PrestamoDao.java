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
	public List<Prestamo> obtener() throws MyDaoExeption;

}
