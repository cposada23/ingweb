package com.edu.udea.iw.logicaNegocio.imp;

import java.util.Calendar;
import java.util.Date;

import com.edu.udea.iw.dao.DispositivoDao;
import com.edu.udea.iw.dao.ReservaDao;
import com.edu.udea.iw.dao.UsuarioDao;
import com.edu.udea.iw.dto.Dispositivo;
import com.edu.udea.iw.dto.Reserva;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;
import com.edu.udea.iw.logicaNegocio.ReservaBL;

public class ReservaBLimp implements ReservaBL {
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

	public ReservaDao getReservaDao() {
		return reservaDao;
	}

	public void setReservaDao(ReservaDao reservaDao) {
		this.reservaDao = reservaDao;
	}
	@Override
	public void realizarReserva(String usuarioReserva, int dispositivo) throws MyDaoExeption {
		if("".equals(usuarioReserva.trim())){
			throw new MyDaoExeption("Se debe especificar el usuario que realiza la reserva",null);
		}
		
		Usuario usuario = usuarioDao.obtenerPorCedula(usuarioReserva);
		if(usuario == null){
			throw new MyDaoExeption("El usuario no esta registrado en el sistema", null);
		}
		Dispositivo dis = dispositivoDao.obtenerPorCodigo(dispositivo);
		if(dis == null){
			throw new MyDaoExeption("No se encuentra un dispositivo con ese codigo", null);
		}
		if(!dis.isEstado()){
			throw new MyDaoExeption("El dispositivo no se encuentra disponible", null);
		}

		Reserva reserva = new Reserva();
		reserva.setAprobado(false);
		reserva.setDispositivo(dis);
		
		reserva.setUsuarioReserva(usuario);
		
		Date fechaInicio = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(fechaInicio);
		cal.add(Calendar.DAY_OF_YEAR, 1); // <--
		Date fechaFin = cal.getTime();
		reserva.setFechaReserva(fechaInicio);
		reserva.setVence(fechaFin);
		try {
			reservaDao.crearReserva(reserva);
		} catch (MyDaoExeption e) {
			throw new MyDaoExeption("Error creando la reserva",null);
		}
		
	}

	@Override
	public void aprobarReserva(String usuarioAprueba, Reserva reserva) throws MyDaoExeption {
		// TODO Auto-generated method stub

	}

}
