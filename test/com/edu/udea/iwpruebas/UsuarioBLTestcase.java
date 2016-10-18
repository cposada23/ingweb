package com.edu.udea.iwpruebas;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.exeption.MyDaoExeption;
import com.edu.udea.iw.logicaNegocio.UsuarioBL;


@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations=("classpath:configuracion.xml"))
public class UsuarioBLTestcase {
	
	
	@Autowired
	UsuarioBL usuarioBL;

	@Test
	public void testValidarUP() {
		try {
			assertTrue(usuarioBL.validarUP("1234556", "elver"));
		} catch (MyDaoExeption e) {
			// TODO: handle exception
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testCrearInvestigador(){
		try {
			String nombre = "Camilo3";
			String apellidos = "posada angel";
			String cedula = "121212";
			String email = "cposadaa@gmail.com";
			String contrasena = "camilo";
			usuarioBL.crearInvestigador(cedula, nombre, apellidos, contrasena, email);
		} catch (MyDaoExeption e) {
			fail(e.getMessage());
		}
	}

}
