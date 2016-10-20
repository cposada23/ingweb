package com.edu.udea.iwpruebas;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.exeption.MyDaoExeption;
import com.edu.udea.iw.logicaNegocio.ReservaBL;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuracion.xml"))
public class ReservaBLTestCase {

	@Autowired
	ReservaBL reservaBL;
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

	
	public void testAprobarReserva() {
		fail("Not yet implemented");
	}

}
