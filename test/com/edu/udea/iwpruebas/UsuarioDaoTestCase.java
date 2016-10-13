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
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;




@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations=("classpath:configuracion.xml"))
public class UsuarioDaoTestCase {

	@Autowired  
	UsuarioDao dao;

	
	@Test
	public void testObtener() {
		List<Usuario> usuarios = null;
		try{
			
			usuarios = dao.obtener();
			if(usuarios.size()>0){
				for (Usuario usuario: usuarios){
					System.out.println(usuario.getNombres()+ "," + usuario.getEmail());
				}
			}
			assertTrue(usuarios.size()> 0);
			
		}catch (MyDaoExeption e) {
			System.out.println(e.getMessage());
			fail(e.getMessage());
			
		}
	}

	

	/*
	public void testUsuarioBL(){
		try {
			assertTrue(usuarioBL.validarUP("Elver", "elver"));
		} catch (MyDaoExeption e) {
			// TODO: handle exception
			fail(e.getMessage());
		}
	}

	

	public void testCrear(){
		
		Usuario usuario = new Usuario();
		usuario.setNombres("Camilo");
		usuario.setApellidos("Posada Angel");
		usuario.setLogin("Camilo");
		Rol rol = new Rol();
		rol.setCodigo("ADM");
		usuario.setRol(rol);
		//Contraseña
		usuario.setContrasena(Hash.getHash("hola", "SHA1"));
		try {
			dao.guardar(usuario);
			
		} catch (MyDaoExeption e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		
		
		
	}*/
}
