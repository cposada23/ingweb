package com.edu.udea.iw.logicaNegocio.imp;

import com.edu.udea.iw.dao.UsuarioDao;
import com.edu.udea.iw.dto.Rol;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;
import com.edu.udea.iw.logicaNegocio.UsuarioBL;
import com.edu.udea.iw.utils.Cifrar;
import com.edu.udea.iw.utils.Validaciones;

public class UsuarioBLimp implements UsuarioBL {
	
	private UsuarioDao usuarioDao;
	
	private Cifrar  cifrar = new Cifrar();
	
	public UsuarioDao getDao() {
		return usuarioDao;
	}

	public void setDao(UsuarioDao dao) {
		this.usuarioDao = dao;
	}

	
	
	
	@Override
	public boolean validarUP(String cedula, String pws) throws MyDaoExeption {
		// TODO Auto-generated method stub
		//System.out.println(cifrar.encrypt(pws));
		
		Usuario  user = usuarioDao.obtenerPorCedula(cedula);
		
		if(user.getContrasena().equals(cifrar.encrypt(pws))){
			return true;
		}
		
		return false;
	}

	@Override
	public void crearInvestigador(String cedula, String nombre, String apellidos, String contrasena, String email) throws MyDaoExeption {
		
		
		if("".equals(cedula.trim())|| cedula == null){
			throw new MyDaoExeption("Se debe especificar la cédula del investigador", null);
		}
		else if("".equals(nombre.trim())|| nombre == null){
			throw new MyDaoExeption("Se debe especificar el nombre del investigador", null);
		}else if("".equals(apellidos.trim())|| apellidos == null){
			throw new MyDaoExeption("Se debe especificar los apellidos del investigador", null);
		}else if("".equals(contrasena.trim())|| contrasena == null){
			throw new MyDaoExeption("Se debe especificar la contrasena del investigador", null);
		}else if(contrasena.length()<5){
			throw new MyDaoExeption("La contraseña debe tener al menos 5 caracteres", null);
		}else if(!Validaciones.isEmail(email)){
			throw new MyDaoExeption("El email debe tener un formato correcto", null);
		}else if(usuarioDao.obtenerPorCedula(cedula)!=null){
			throw new MyDaoExeption("El usuario ya existe", null);
		}
		
		
		Usuario usuario = new Usuario();
		usuario.setNombres(nombre);
		usuario.setApellidos(apellidos);
		usuario.setCedula(cedula);
		usuario.setEmail(email);
		Rol rol = new Rol();
		rol.setCodigo("INV");
		usuario.setRol(rol);
		usuario.setContrasena(cifrar.encrypt(contrasena));
		
		try {
			usuarioDao.guardar(usuario);
		} catch (MyDaoExeption e) {
			throw new MyDaoExeption("Error guardando el usuario, intente de nuevo",null);
		}
		
		
	}

	

}
