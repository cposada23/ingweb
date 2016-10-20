package com.edu.udea.iwpruebas;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.dao.UsuarioDao;
import com.edu.udea.iw.dto.Rol;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;
import com.edu.udea.iw.utils.Cifrar;




@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations=("classpath:configuracion.xml"))
public class UsuarioDaoTestCase {

	@Autowired  
	UsuarioDao dao;
	
	

	
	/**
	 * Obtener la lista de usuario de la base de datos 
	 * la prueba falla si esta lista no contiene ningun objeto
	 */
	
	
	public void testObtener() {
		List<Usuario> usuarios = null;
		try{
			
			usuarios = dao.obtener();
			assertTrue(usuarios.size()> 0);
			
		}catch (MyDaoExeption e) {
			//System.out.println(e.getMessage());
			fail(e.getMessage());
			
		}
	}
	
	
	/**
	 * Obtiene un usuario de la base de datos dada su cedula 
	 * la prueba falla si no se obtiene un usuario con la cedula dada
	 * ya que sabemos que en la base de datos hay un usuario con la cedula
	 * 1234556
	 */
	
	
	public void testObtenerPorCedula(){
		Usuario usuario = null;
		String cedula = "1234556";
	
		try {
			usuario = dao.obtenerPorCedula(cedula);
			assertTrue("Elver".equals(usuario.getNombres()));
			
		} catch (MyDaoExeption e) {
			
			fail(e.getMessage());
		}
	}

	
	/**
	 * Se verifica que no se obtenga ningun usuario cuando se pasa
	 * una cedula que no esta registrada en la bd
	 */

	public void testUsuariNoExiste(){
		Usuario usuario = null;
		String cedula = "333";
		try {
			usuario = dao.obtenerPorCedula(cedula);
			assertTrue(usuario == null);
			
		} catch (MyDaoExeption e) {
			fail("No se deberia encontrar un usuario con esa cedula");
		}
		
	}
	

	public void testGuardar(){
		Usuario usuario = new Usuario();
		Cifrar cifrar = new Cifrar();
		Rol rol = new Rol();
		rol.setCodigo("ADM");
		usuario.setNombres("Camilo2");
		usuario.setCedula("987654321");
		usuario.setApellidos("Posada");
		usuario.setContrasena(cifrar.encrypt("camilo"));
		usuario.setEmail("cposadaa@gmail.com");
		usuario.setRol(rol);
		
		
		try {
			dao.guardar(usuario);
			//rol = rolDao.obtener("ADM");
			//System.out.println(rol.getCodigo()+  " " + rol.getNombre());
			assertTrue(true);
		} catch (MyDaoExeption e) {
			// TODO: handle exception
			fail(e.getMessage());
		}
	}
	
	

	public void testActualizar(){
		Usuario usuario= null;
		try {
			usuario = dao.obtenerPorCedula("1234556");
			usuario.setNombres("Elver");
			dao.actualizar(usuario);
		} catch (MyDaoExeption e) {
			fail(e.getMessage());
			
		}
		
	}
	
	@Test
	public void testObtenerPorEmail(){
		Usuario usuario = null;
		try {
			String email = "elver@elver.com";
			usuario = dao.obtenerPorEmail(email);
			assertTrue("Elver".equals(usuario.getNombres()));
		} catch (MyDaoExeption e) {
			fail(e.getMessage());
		}
	}
}
