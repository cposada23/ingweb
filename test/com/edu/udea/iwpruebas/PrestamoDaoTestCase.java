package com.edu.udea.iwpruebas;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.dao.PrestamoDao;
import com.edu.udea.iw.dto.Prestamo;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuracion.xml"))

public class PrestamoDaoTestCase {

	@Autowired
	PrestamoDao prestamoDao;
	@Test
	public void testObtener() {
		List<Prestamo> prestamos = null;
	
		try {
			prestamos = prestamoDao.obtener();
			if(prestamos.size()>0){
				for(Prestamo prestamo: prestamos){
					System.out.println(prestamo.getCodigo()+ ","+ prestamo.getFechaInicio());
				}
			}
			assertTrue(prestamos.size()>0);
		} catch (MyDaoExeption e) {
			// TODO: handle exception
			fail(e.getMessage());
		}
	}
	
	
	@Test 
	public void testObtenerCodigo(){
		Prestamo prestamo = null;
		int codigo = 3;
		try {
			prestamo = prestamoDao.obtenerPorCodigo(codigo);
			assertTrue(prestamo.getUsuarioAprueba().getCedula().equals("1234556"));
			
		} catch (MyDaoExeption e) {
			fail(e.getMessage());
		}
	}

	
	@Test 
	public void testObtenerPrestamosUsuario(){
		List<Prestamo> prestamos = null;
		Usuario usuario = new Usuario();
		usuario.setCedula("9876543");
		try {
			prestamos = prestamoDao.obtenerPrestamosUsuario(usuario);
			assertTrue(prestamos.size()>0);
		} catch (MyDaoExeption e) {
			fail(e.getMessage());
		}
	}
}
