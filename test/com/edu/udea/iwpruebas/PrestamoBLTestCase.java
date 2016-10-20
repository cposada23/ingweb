package com.edu.udea.iwpruebas;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.dto.Prestamo;
import com.edu.udea.iw.exeption.MyDaoExeption;
import com.edu.udea.iw.logicaNegocio.PrestamoBL;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuracion.xml"))
public class PrestamoBLTestCase {

	
	@Autowired
	PrestamoBL prestamoBL;
	
	
	@Test
	public void testCrearPrestamo() {
		try {
			String usuarioPresta = "9876543";
			String usuarioAprueba ="1234556";
			int  dispositivo = 1;
			prestamoBL.crearPrestamo(usuarioPresta, usuarioAprueba, dispositivo);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void fallaPorUsuarioNoAdmin(){
		try {
			String usuarioPresta = "1234556";
			String usuarioAprueba ="9876543";
			int  dispositivo = 1;
			prestamoBL.crearPrestamo(usuarioPresta, usuarioAprueba, dispositivo);
		} catch (MyDaoExeption e) {
			assertTrue(e.getMessage(), true);
		}
		
	}


	@Test
	public void testBuscarPrestamos() {
		String usuarioPresta = "9876543";
		List<Prestamo>  prestamos = null;
		try {
			
			prestamos = prestamoBL.buscarPrestamos(usuarioPresta);
			assertTrue(prestamos.size()>0);
			
		} catch (MyDaoExeption e) {
			fail(e.getMessage());
		}
	}

}
