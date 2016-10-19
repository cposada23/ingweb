package com.edu.udea.iw.logicaNegocio.imp;

import java.util.Date;

import com.edu.udea.iw.dao.DispositivoDao;
import com.edu.udea.iw.dao.UsuarioDao;
import com.edu.udea.iw.dto.Dispositivo;
import com.edu.udea.iw.dto.Tipo;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;
import com.edu.udea.iw.logicaNegocio.DispositivoBL;

public class DispositivoBLimp implements DispositivoBL {
	
	
	private UsuarioDao usuarioDao;
	private DispositivoDao dispositivoDao;

	@Override
	public void crearDispositivo(int codigo, String descripcion, String usuarioCrea, String tipo) throws MyDaoExeption {
		if("".equals(descripcion.trim())){
			throw new MyDaoExeption("Debe ingresar la descripcion del dispositivo", null);
		}else if("".equals(usuarioCrea.trim())){
			throw new MyDaoExeption("Se debe especificar quien crea el dispositivo", null);
		}else if("".equals(tipo.trim())){
			throw new MyDaoExeption("Se debe especificar el tipo del dispositivo", null);
		}
		Usuario creador = usuarioDao.obtenerPorCedula(usuarioCrea);
		
		if(creador==null){
			throw new MyDaoExeption("El usuario que crea no existe", null);
		}else if(!creador.getRol().getCodigo().equals("ADM")){
			throw new MyDaoExeption("Para crear un dispositivo debe ser un administrador", null);
		}
		
		Tipo t = new Tipo();
		t.setCodigo(tipo);
		
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.setCodigo(codigo);
		dispositivo.setDescripcion(descripcion);
		dispositivo.setUsuarioCrea(creador);
		dispositivo.setEliminado(false);
		dispositivo.setEstado(true);
		dispositivo.setFechaCrea(new Date());
		
		try {
			dispositivoDao.crear(dispositivo);
		} catch (MyDaoExeption e) {
			throw new MyDaoExeption("Error creando dispositivo", null);
		}
		
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public DispositivoDao getDispositivoDao() {
		return dispositivoDao;
	}

	public void setDispositivoDao(DispositivoDao dispositivoDao) {
		this.dispositivoDao = dispositivoDao;
	}

}
