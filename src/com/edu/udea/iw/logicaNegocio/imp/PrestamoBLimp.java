package com.edu.udea.iw.logicaNegocio.imp;

import static org.hamcrest.CoreMatchers.theInstance;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.edu.udea.iw.dao.DispositivoDao;
import com.edu.udea.iw.dao.PrestamoDao;
import com.edu.udea.iw.dao.UsuarioDao;
import com.edu.udea.iw.dto.Dispositivo;
import com.edu.udea.iw.dto.Prestamo;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;
import com.edu.udea.iw.logicaNegocio.PrestamoBL;

public class PrestamoBLimp implements PrestamoBL {
	
	
	
	private UsuarioDao usuarioDao;
	private DispositivoDao dispositivoDao;
	private PrestamoDao prestamoDao;

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

	public PrestamoDao getPrestamoDao() {
		return prestamoDao;
	}

	public void setPrestamoDao(PrestamoDao prestamoDao) {
		this.prestamoDao = prestamoDao;
	}

	@Override
	public void crearPrestamo(String usuarioPresta, String usuarioAprueba, int dispositivo) throws MyDaoExeption {
		// TODO Auto-generated method stub
		
		if("".equals(usuarioPresta.trim())){
			throw new MyDaoExeption("Se debe especificar el usuario que presta el dispositivo",null);
		}
		
		Usuario prestador = usuarioDao.obtenerPorCedula(usuarioPresta);
		
		if(prestador == null){
			throw new MyDaoExeption("No existe ningun usuario registrado con esa cedula", null);
		}
		if("".equals(usuarioAprueba.trim())){
			throw new MyDaoExeption("Se debe especificar el usuario que aprueba el prestamo",null);
		}
		
		Usuario uAprueba = usuarioDao.obtenerPorCedula(usuarioAprueba);
		if(uAprueba == null){
			throw new MyDaoExeption("No existe ningun usuario registrado con esa cedula", null);
		}if(!uAprueba.getRol().getCodigo().equals("ADM")){
			throw new MyDaoExeption("El usuario que aprueba debe ser un administrador", null);
		}
		
		Dispositivo dis= dispositivoDao.obtenerPorCodigo(dispositivo);
		if(dis == null){
			throw new MyDaoExeption("No existe el dispositivo", null);
		}
		
		Date fechaInicio = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(fechaInicio);
		cal.add(Calendar.DAY_OF_YEAR, 1); // <--
		Date fechaFin = cal.getTime();
		
		Prestamo prestamo = new Prestamo();
		prestamo.setDispositivo(dis);
		prestamo.setFechaFin(fechaFin);
		prestamo.setFechaInicio(fechaInicio);
		prestamo.setUsuarioAprueba(uAprueba);
		prestamo.setUsuarioPresta(prestador);
		
		try {
			prestamoDao.guardar(prestamo);
		} catch (MyDaoExeption e) {
			throw new MyDaoExeption("Error guardando el prestamo", null);		}
		
	}

	@Override
	public List<Prestamo> buscarPrestamos(String usuarioPresta) throws MyDaoExeption {
		if("".equals(usuarioPresta.trim())){
			throw new MyDaoExeption("Se debe especificar el usuario que presta", null);
		}
		Usuario usuario = usuarioDao.obtenerPorCedula(usuarioPresta);
		if(usuario == null ){
			throw new MyDaoExeption("El usuario no existe en la bd", null);
		}
		List<Prestamo> prestamos = null;
		try {
			prestamos = prestamoDao.obtenerPrestamosUsuario(usuario);
		} catch (Exception e) {
			throw new MyDaoExeption("Error obteniendo los prestamos del usuario", null);
		}
		
		return prestamos;
	}

}
