package com.edu.udea.iw.logicaNegocio;

import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;

/**
 * Interface para validar la logica del negocio con respecto a los usuarios
 * @author Camilo Posada Angel - cposadaa@gmail.com
 *
 */
public interface UsuarioBL {
	
 /**
  * Valida el usuario y la contraseña en la base de datos
  * @param cedula
  * @param pws
  * @return
  * @throws MyDaoExeption
  */
	public boolean validarUP(String cedula, String pws) throws MyDaoExeption;
	
	
	/**
	 * creacion de un nuevo investigador 
	 * @param cedula
	 * @param nombre
	 * @param apellidos
	 * @param contrasena
	 * @param email
	 * @param rol
	 * @throws MyDaoExeption
	 */
	public void crearInvestigador(String cedula, String nombre, String apellidos, String contrasena, String email) throws MyDaoExeption;

	/**
	 * Valida un el email y contraseña de un usuario
	 * @param email
	 * @param pws
	 * @return
	 * @throws MyDaoExeption
	 */
	public boolean validarUE(String email, String pws) throws MyDaoExeption;
	
	
	/**
	 * Valida el email y contraseña de un usuario 
	 * @param email
	 * @param pws
	 * @return el usuario en caso de que la cotraseña y el email esten correctos
	 * @throws MyDaoExeption en caso de que el usuario no se encuentre o la contraseña este mala
	 */
	public Usuario validar(String email, String pws) throws MyDaoExeption;
}
