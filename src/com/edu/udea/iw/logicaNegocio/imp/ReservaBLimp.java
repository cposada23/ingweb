package com.edu.udea.iw.logicaNegocio.imp;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.edu.udea.iw.dao.DispositivoDao;
import com.edu.udea.iw.dao.PrestamoDao;
import com.edu.udea.iw.dao.ReservaDao;
import com.edu.udea.iw.dao.UsuarioDao;
import com.edu.udea.iw.dto.Dispositivo;
import com.edu.udea.iw.dto.Prestamo;
import com.edu.udea.iw.dto.Reserva;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;
import com.edu.udea.iw.logicaNegocio.ReservaBL;
import com.edu.udea.iw.logicaNegocio.UsuarioBL;
/**
 * Clase de Reserva para la logica del negocio que implementa la interface ReservaBL
 * @author  Camilo Posada Angel - cposadaa@gmail.com
 */
public class ReservaBLimp implements ReservaBL {
	private UsuarioDao usuarioDao;
	private DispositivoDao dispositivoDao;
	private ReservaDao reservaDao;
	private PrestamoDao prestamoDao;
	
	public PrestamoDao getPrestamoDao() {
		return prestamoDao;
	}

	public void setPrestamoDao(PrestamoDao prestamoDao) {
		this.prestamoDao = prestamoDao;
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
		if("".equals(usuarioAprueba.trim())){
			throw new MyDaoExeption("Se debe especificar el usuario que aprueba la reserva", null);
		}
		Usuario usuario = usuarioDao.obtenerPorCedula(usuarioAprueba);
		if(usuario == null){
			throw new MyDaoExeption("El usuario que aprueba no se encuentra registrado en la base de datos", null);
		}
		if(!"ADM".equals(usuario.getRol().getCodigo())){
			throw new MyDaoExeption("La reserva solo puede ser aprobada por un administrador", null);
		}
		
		if(reserva == null){
			throw new MyDaoExeption("Se debe especificar la reserva a ser aprobada", null);
		}
		if(reserva.getAprobado()){
			throw new MyDaoExeption("La reserva ya fue aprobada", null);
		}
		

		Usuario usuarioPresta = usuarioDao.obtenerPorCedula(reserva.getUsuarioReserva().getCedula());
		if(usuarioPresta == null){
			throw new MyDaoExeption("No se pudo encontrar el usuario que hizo la reserva, intente de nuevo", null);
		}
		Dispositivo dispositivo = dispositivoDao.obtenerPorCodigo(reserva.getDispositivo().getCodigo());
		reserva.setAprobado(true);
		reserva.setUsuarioAprueba(usuario);
		Date fechaInicio = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(fechaInicio);
		cal.add(Calendar.DAY_OF_YEAR, 1); // <--
		Date fechaFin = cal.getTime();
		try {
			reservaDao.actualizarReserva(reserva);
			Prestamo prestamo = new Prestamo();
			prestamo.setUsuarioAprueba(usuario);
			prestamo.setUsuarioPresta(usuarioPresta);
			prestamo.setDispositivo(dispositivo);
			prestamo.setFechaFin(fechaFin);
			prestamo.setFechaInicio(fechaInicio);
			prestamoDao.guardar(prestamo);
		} catch (MyDaoExeption e) {
			throw new MyDaoExeption("Error aprobando la reserva intente de nuevo", null);
		}
		
	}

	@Override
	public List<Reserva> misReservas(String usuarioReserva) throws MyDaoExeption {
		if("".equals(usuarioReserva.trim())){
			throw new MyDaoExeption("Se debe especificar el id del usuario que reserva", null);
		}
		
		Usuario usuario = usuarioDao.obtenerPorCedula(usuarioReserva);
		
		if(usuario == null){
			throw new MyDaoExeption("No se encontro el usuario con esa cedula", null);
		}
		
		List <Reserva> reservas = reservaDao.ObtenerReservaPorUsuario(usuario);
		if(reservas== null){
			throw new MyDaoExeption("El usuario no tiene reservas", null);
		}
		return reservas;
	}

	@Override
	public void realizarReserva2(String usuarioReserva, int dispositivo, Date fechaInicio) throws MyDaoExeption {
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
		
		List <Reserva> reservas = reservaDao.obtenerReservasDeDispositivos(dis);
		
		for (Reserva r : reservas){
			Date inicio = r.getFechaReserva();
			Date vence = r.getVence();
			if(inicio.compareTo(fechaInicio)==0){
				throw new MyDaoExeption("El dispositivo no esta disponible en esta fecha", null);
			}
		}
		
		List<Prestamo> prestamos = prestamoDao.obtenerPrestamosPorDispositivo(dis);
		
		for(Prestamo p: prestamos){
			
			Date inicio = p.getFechaInicio();
			if(inicio.compareTo(fechaInicio)==0){
				throw new MyDaoExeption("El dispositivo esta prestado en esa fecha", null);
			}
		}
		
		Reserva reserva = new Reserva();
		reserva.setAprobado(false);
		reserva.setDispositivo(dis);
		
		reserva.setUsuarioReserva(usuario);
		
		
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

}
