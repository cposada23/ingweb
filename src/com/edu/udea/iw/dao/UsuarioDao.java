package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;

public interface UsuarioDao {

	/** Obtiene todos los usuarios de la base de datos
	 * 
	 * @return
	 * @throws MyDaoExeption
	 */
	public List<Usuario> obtener() throws MyDaoExeption;
	
	
}
