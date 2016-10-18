package com.edu.udea.iw.logicaNegocio;

import com.edu.udea.iw.exeption.MyDaoExeption;

/**
 * Clase para validar la logica del negocio con respecto a los usuarios
 * @author cposa
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
}
