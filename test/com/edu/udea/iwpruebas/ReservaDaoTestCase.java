package com.edu.udea.iwpruebas;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.dao.DispositivoDao;
import com.edu.udea.iw.dao.ReservaDao;
import com.edu.udea.iw.dao.UsuarioDao;
import com.edu.udea.iw.dto.Dispositivo;
import com.edu.udea.iw.dto.Reserva;
import com.edu.udea.iw.dto.Tipo;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations=("classpath:configuracion.xml"))
public class ReservaDaoTestCase {

	
	@Autowired
	ReservaDao reservaDao;
	

	
	@Test
	public void testGetDispositivos() {
		List<Reserva> reservas = null;
		try{
			
			reservas = reservaDao.obtenerReservas();
			if(reservas.size()>0){
				for (Reserva reserva: reservas){
					System.out.println(reserva.getCodigo()+ ", usuario :    " + reserva.getUsuarioReserva().getCedula()+", "+reserva.isAprobado());
				}
			}
			assertTrue(reservas.size()> 0);
			
		}catch (MyDaoExeption e) {
			//System.out.println(e.getMessage());
			fail(e.getMessage());
			
		}
		
	}
	
	@Test
	public void testNoAprobados(){
		List<Reserva> reservas = null;
		try{
			
			reservas = reservaDao.obtenerReservasNoAprobadas();
			if(reservas.size()>0){
				for (Reserva reserva: reservas){
					System.out.println(reserva.getCodigo()+", "+reserva.isAprobado());
				}
			}
			assertTrue(reservas.size()> 0);
			
		}catch (MyDaoExeption e) {
			//System.out.println(e.getMessage());
			fail(e.getMessage());
			
		}
		
	}
	
	@Test
	public void testbuscarPorUsuario(){
		Usuario usuario = new Usuario();
		List<Reserva> reserva = null;
		usuario.setCedula("1234556");
		try{			
			reserva = reservaDao.ObtenerReservaPorUsuario(usuario);
			if(reserva.size()>0){
				for(Reserva rese:reserva){
					System.out.println(rese.getCodigo()+", "+rese.getUsuarioReserva().getCedula());
				}
			}
			
			assertTrue(reserva.size()>0);
		}catch (MyDaoExeption e) {
			fail(e.getMessage());
		}
	}


}
