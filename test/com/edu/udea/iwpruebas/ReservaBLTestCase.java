package com.edu.udea.iwpruebas;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.dao.ReservaDao;
import com.edu.udea.iw.dto.Reserva;
import com.edu.udea.iw.exeption.MyDaoExeption;
import com.edu.udea.iw.logicaNegocio.ReservaBL;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuracion.xml"))
public class ReservaBLTestCase {

	@Autowired
	ReservaBL reservaBL;
	@Autowired
	ReservaDao reservaDao;
	@Test
	public void testRealizarReserva() {
		String usuarioReserva = "9876543";
		int dispositivo = 1;
		try {
			reservaBL.realizarReserva(usuarioReserva, dispositivo);
		} catch (MyDaoExeption e) {
			fail(e.getMessage());
		}
		
	}

	@Test
	public void testAprobarReserva() {
		String usuarioAprueba = "1234556";
		
		
		try {
			Reserva reserva = reservaDao.obtenerReserva(1);
			reservaBL.aprobarReserva(usuarioAprueba, reserva);
		} catch (MyDaoExeption e) {
			fail(e.getMessage());
		}
	}

}
