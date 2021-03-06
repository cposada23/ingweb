package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;
/**
 * Interface de Usuario 
 * @author Camilo Posada Angel - cposadaa@gmail.com
 */
public interface UsuarioDao {

	/** Obtiene todos los usuarios de la base de datos
	 * 
	 * @return
	 * @throws MyDaoExeption
	 */
	public List<Usuario> obtener() throws MyDaoExeption;
	
	
	
	/**
	 * Obtiene un usuario de la base de datos por medio de su cedula
	 * @param cedula
	 * @return Usuario si existe
	 * @throws MyDaoExeption en caso de que no exista el usuario en la base de datos
	 */
	public Usuario obtenerPorCedula(String cedula) throws MyDaoExeption;
	
	/**
	 * Guarda un nuevo usuario en la bd
	 * @param usuario
	 * @throws MyDaoExeption
	 */
	public void guardar(Usuario usuario) throws MyDaoExeption;
	
	
	/**
	 * actualiza los datos de un usuario en la bd
	 * @param usuario
	 * @throws MyDaoExeption
	 */
	public void actualizar(Usuario usuario) throws MyDaoExeption;
	
	/**
	 * Obtiene un usuario a partir de su email
	 * @param email
	 * @throws MyDaoExeption
	 */
	public Usuario obtenerPorEmail(String email) throws MyDaoExeption;
	
	
}
