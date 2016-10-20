package com.edu.udea.iw.logicaNegocio.imp;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.edu.udea.iw.dao.DispositivoDao;
import com.edu.udea.iw.dao.ReservaDao;
import com.edu.udea.iw.dao.UsuarioDao;
import com.edu.udea.iw.dao.hibernate.DispositivoDaoImp;
import com.edu.udea.iw.dao.hibernate.UsuarioDaoImpHibernate;
import com.edu.udea.iw.dto.Dispositivo;
import com.edu.udea.iw.dto.Reserva;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;
import com.edu.udea.iw.logicaNegocio.ReservaBL;

public class ReservaBLImp implements ReservaBL{
	
	private UsuarioDao usuarioDao;
	private DispositivoDao dispositivoDao;
	private ReservaDao reservaDao;
	
	

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
	public void crearReserva(String usuarioReserva,  Date fechaReserva, int dispositivo)
			throws MyDaoExeption {

		Usuario usuario = usuarioDao.obtenerPorCedula(usuarioReserva);
		if(usuario==null){
			throw new MyDaoExeption("Se debe especificar el usuario que reserva el dispositivo",null);
		}
		Dispositivo dispo = dispositivoDao.obtenerPorCodigo(dispositivo);
		if(dispo == null){
			throw new MyDaoExeption("Se debe especificar el dispositivo a prestar",null);
		}
		
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(fechaReserva);
		cal.add(Calendar.MINUTE, -15); // <--
		Date fechaFin = cal.getTime();
		
		Reserva reserva = new Reserva();
		reserva.setAprobado(0);
		reserva.setDispositivo(dispo);
		reserva.setFechaReserva(fechaReserva);
		reserva.setUsuarioAprueba(null);
		reserva.setUsuarioReserva(usuario);
		reserva.setVence(fechaFin);
		
		try{
			reservaDao.crearReserva(reserva);
		}catch (MyDaoExeption e) {
			throw new MyDaoExeption("Error guardando la reserva", null);
		}
		
		

		
		
	}

	@Override
	public List<Reserva> buscarReserva(String usuarioReserva) throws MyDaoExeption {
		Usuario usuario = usuarioDao.obtenerPorCedula(usuarioReserva);
		if(usuario==null){
			throw new MyDaoExeption("Se debe especificar el usuario que reserva el dispositivo",null);
		}
		List<Reserva> reservas=null;
		try{
			reservas = reservaDao.ObtenerReservaPorUsuario(usuario);
		}catch (MyDaoExeption e) {
			throw new MyDaoExeption("No existen reservas hechas por el usuario",null);
		}
		
		return reservas;
		
	}

}
