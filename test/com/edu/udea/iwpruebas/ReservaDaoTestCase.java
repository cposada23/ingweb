package com.edu.udea.iwpruebas;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.dao.ReservaDao;
import com.edu.udea.iw.dto.Reserva;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuracion.xml"))

public class ReservaDaoTestCase {

	@Autowired
	ReservaDao reservaDao;
	
	@Test
	public void testObtener() {
		List<Reserva> reservas = null;
		try {
			reservas = reservaDao.obtener();
			
			assertTrue(reservas.size()>0);
		} catch (MyDaoExeption e) {
			fail(e.getMessage());
		}
	}

	
	@Test
	public void testNoAprobados(){
		List<Reserva> reservas = null;
		try{
			
			reservas = reservaDao.obtenerReservasNoAprobadas();
			
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
			
			assertTrue(reserva.size()>0);
		}catch (MyDaoExeption e) {
			fail(e.getMessage());
		}
	}
}
