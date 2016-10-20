package com.edu.udea.iw.logicaNegocio.imp;

import java.util.Date;

import com.edu.udea.iw.dao.DispositivoDao;
import com.edu.udea.iw.dao.UsuarioDao;
import com.edu.udea.iw.dto.Dispositivo;
import com.edu.udea.iw.dto.Tipo;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;
import com.edu.udea.iw.logicaNegocio.DispositivoBL;
/**
 * Clase de Dispositivo para la logica del negocio que implementa la interface DispositivoBL
 * @author  Camilo Posada Angel - cposadaa@gmail.com
 */
public class DispositivoBLimp implements DispositivoBL {
	
	
	private UsuarioDao usuarioDao;
	private DispositivoDao dispositivoDao;
	
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
	
	@Override
	public void actualizarDatos(String usuarioActualiza, Dispositivo dispositivo) throws MyDaoExeption {
		if("".equals(usuarioActualiza.trim())){
			throw new MyDaoExeption("Se debe especificar el usuario que actualiza el dispositivo", null);
		}
		
		Usuario usuario = usuarioDao.obtenerPorCedula(usuarioActualiza);
		if(usuario == null){
			throw new MyDaoExeption("El usuario que actualiza no se encontro en la base de datos", null);
		}
		if(!"ADM".equals(usuario.getRol().getCodigo())){
			throw new MyDaoExeption("El usuario que actualiza los datos debe ser un administrador", null);
		}
		
		if(dispositivo == null){
			throw new MyDaoExeption("Se debe especificar el dispositivo a ser actualizado", null);
		}
		if(dispositivo.isEliminado()){
			throw new MyDaoExeption("Esta tratando de actualizar un dispositivo que ya ha sido eliminado", null);
		}
		
		try {
			dispositivoDao.actualizar(dispositivo);
		} catch (MyDaoExeption e) {
			throw new MyDaoExeption("Error actualizando el dispositivo", null);
		}
		
	}

	@Override
	public void actualizarDisponibilidad(String usuarioActualiza, Dispositivo dispositivo) throws MyDaoExeption {
		if("".equals(usuarioActualiza.trim())){
			throw new MyDaoExeption("Se debe especificar el usuario que actualiza el dispositivo", null);
		}
		
		Usuario usuario = usuarioDao.obtenerPorCedula(usuarioActualiza);
		if(usuario == null){
			throw new MyDaoExeption("El usuario que actualiza no se encontro en la base de datos", null);
		}
		if(!"ADM".equals(usuario.getRol().getCodigo())){
			throw new MyDaoExeption("El usuario que actualiza los datos debe ser un administrador", null);
		}
		
		if(dispositivo == null){
			throw new MyDaoExeption("Se debe especificar el dispositivo a ser actualizado", null);
		}
		if(dispositivo.isEliminado()){
			throw new MyDaoExeption("Esta tratando de actualizar un dispositivo que ya ha sido eliminado", null);
		}
		if(dispositivo.isEstado()){
			throw new MyDaoExeption("El dispositivo ya esta disponible", null);
		}
		
		try {
			dispositivo.setEstado(true);
			dispositivoDao.actualizar(dispositivo);
		} catch (MyDaoExeption e) {
			throw new MyDaoExeption("Error actualizando el dispositivo", null);
		}
		
	}

	@Override
	public void eliminarDispositivo(String usuarioElimina, Dispositivo dispositivo) throws MyDaoExeption {
		
		if("".equals(usuarioElimina.trim())){
			throw new MyDaoExeption("Se debe especificar el usuario que actualiza el dispositivo", null);
		}
		
		Usuario usuario = usuarioDao.obtenerPorCedula(usuarioElimina);
		if(usuario == null){
			throw new MyDaoExeption("El usuario que elimina no se encontro en la base de datos", null);
		}
		if(!"ADM".equals(usuario.getRol().getCodigo())){
			throw new MyDaoExeption("El usuario que elimina el dispositivo debe ser un administrador", null);
		}
		
		if(dispositivo == null){
			throw new MyDaoExeption("Se debe especificar el dispositivo a ser eliminado", null);
		}
		if(dispositivo.isEliminado()){
			throw new MyDaoExeption("Esta tratando de actualizar un dispositivo que ya ha sido eliminado", null);
		}
		
		
		try {
			dispositivo.setEliminado(true);
			dispositivoDao.actualizar(dispositivo);
		} catch (MyDaoExeption e) {
			throw new MyDaoExeption("Error eliminado el dispositivo", null);
		}
		
	}

	@Override
	public Dispositivo listarDispositivoPorCodigo(String usuarioBusca, int codigo) throws MyDaoExeption {
		if("".equals(usuarioBusca.trim())){
			throw new MyDaoExeption("Se debe especificar el usuario que busca el dispositivo", null);
		}
		
		Usuario usuario = usuarioDao.obtenerPorCedula(usuarioBusca);
		if(usuario == null){
			throw new MyDaoExeption("El usuario que busca no se encontro en la base de datos", null);
		}
		Dispositivo dispositivo = null;
		try {
			dispositivo = dispositivoDao.obtenerPorCodigo(codigo);
		} catch (MyDaoExeption e) {
			throw new MyDaoExeption("Error buscando el dispositivo", null);
		}
		
		if(dispositivo == null){
			throw new MyDaoExeption("No se encontro un dispositivo con ese codigo en la base de datos", null);
		}
		
		return dispositivo;
	}

	

	

}
