package com.edu.udea.iwpruebas;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.dao.DispositivoDao;
import com.edu.udea.iw.dto.Dispositivo;
import com.edu.udea.iw.exeption.MyDaoExeption;
import com.edu.udea.iw.logicaNegocio.DispositivoBL;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuracion.xml"))
public class DispositivoBLtestCase {

	@Autowired
	DispositivoBL dispositivoBL;
	@Autowired 
	DispositivoDao dispositivoDao;
	
	@Test
	public void testCrearDispositivo() {
		try {
			int codigo = 3;
			String descripcion = "prueba";
			String usuarioCrea = "1234556";
			String tipo = "pc";
			dispositivoBL.crearDispositivo(codigo, descripcion, usuarioCrea, tipo);
		} catch (MyDaoExeption e) {
			fail(e.getMessage());
		}
	}
	
	/**
	 * Para crear un dispositivo el usuario debe ser un administrador
	 * si se captura la exepcion correctamente la prueba pasa
	 */
	@Test
	public void testFalloUsuarioCrea(){
		
		try {
			int codigo = 3;
			String descripcion = "prueba";
			String usuarioCrea = "9876543";
			String tipo = "pc";
			dispositivoBL.crearDispositivo(codigo, descripcion, usuarioCrea, tipo);
			fail("Para crear un dispositivo se debe ser un administrador");
		} catch (MyDaoExeption e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testActualizar(){
		Dispositivo dispositivo = null;
		String usuarioActualiza = "1234556";
		try {
			dispositivo = dispositivoDao.obtenerPorCodigo(1);
			dispositivo.setDescripcion("Otra descripcion");
			dispositivoBL.actualizarDatos(usuarioActualiza, dispositivo);
		} catch (MyDaoExeption e) {
			fail(e.getMessage());
		}
		
		
	}
	
	@Test 
	public void testActualizarEstado(){
		Dispositivo dispositivo = null;
		String usuarioActualiza = "1234556";
		try {
			dispositivo = dispositivoDao.obtenerPorCodigo(1);
			dispositivoBL.actualizarDisponibilidad(usuarioActualiza, dispositivo);
		} catch (MyDaoExeption e) {
			fail(e.getMessage());
		}
	}
	
	@Test 
	public void testEliminarDispositivo(){
		Dispositivo dispositivo = null;
		String usuarioElimina = "1234556";
		try {
			dispositivo = dispositivoDao.obtenerPorCodigo(1);
			dispositivoBL.eliminarDispositivo(usuarioElimina, dispositivo);;
		} catch (MyDaoExeption e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void buscarDipositivo(){
		Dispositivo dispositivo = null;
		int codigo = 1;
		String usuarioBusca = "1234556";
		try {
			dispositivo = dispositivoBL.listarDispositivoPorCodigo(usuarioBusca, codigo);
			assertTrue("micro".equals(dispositivo.getTipo().getCodigo()));
		} catch (MyDaoExeption e) {
			fail(e.getMessage());
		}
	}

}
