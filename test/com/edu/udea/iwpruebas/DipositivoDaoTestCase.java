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
import com.edu.udea.iw.dto.Dispositivo;
import com.edu.udea.iw.dto.Tipo;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations=("classpath:configuracion.xml"))
public class DipositivoDaoTestCase {

	
	@Autowired
	DispositivoDao dispositivoDao;
	
	@Test
	public void testGetDispositivos() {
		List<Dispositivo> dispositivos = null;
		try{
			
			dispositivos = dispositivoDao.getDispositivos();
			if(dispositivos.size()>0){
				for (Dispositivo dispositivo: dispositivos){
					System.out.println(dispositivo.getCodigo()+ "," + dispositivo.getDescripcion());
				}
			}
			assertTrue(dispositivos.size()> 0);
			
		}catch (MyDaoExeption e) {
			//System.out.println(e.getMessage());
			fail(e.getMessage());
			
		}
		
	}
	
	@Test
	public void testCrearDispositivo(){
		Dispositivo dispositivo = new Dispositivo();
		Usuario usuarioCrea = new Usuario();
		usuarioCrea.setCedula("1234556");
		Tipo tipo = new Tipo();
		tipo.setCodigo("pc");
		Date fechaCreacion = new Date();
		
		try {
			
			dispositivo.setDescripcion("Un  nuevo dispositivo");
			dispositivo.setUsuarioCrea(usuarioCrea);
			dispositivo.setTipo(tipo);
			dispositivo.setFechaCrea(fechaCreacion);
			dispositivo.setEstado(true);
			dispositivo.setEliminado(false);
			
			dispositivoDao.crear(dispositivo);
			
 		} catch (MyDaoExeption e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test 
	public void getDispositivosDisponiblesPorTipo(){
		List<Dispositivo> dispositivos = null;
		
		Tipo tipo = new Tipo();
		tipo.setCodigo("micro");
		try{
			
			dispositivos = dispositivoDao.listarDispositivosDisponibles(tipo);
			assertTrue(dispositivos.size()> 0);
			
		}catch (MyDaoExeption e) {
			//System.out.println(e.getMessage());
			fail(e.getMessage());
			
		}
	}
	
	@Test 
	public void getDisponibles(){
		List<Dispositivo> dispositivos = null;
		
			
		try{
			
			dispositivos = dispositivoDao.listarDiposnibles();
			assertTrue(dispositivos.size()> 0);
			
		}catch (MyDaoExeption e) {
			//System.out.println(e.getMessage());
			fail(e.getMessage());
			
		}
	}
	
	@Test
	public void getPorCodigo(){
		Dispositivo dispositivo = null;
		try {
			dispositivo = dispositivoDao.obtenerPorCodigo(1);
			assertTrue("micro".equals(dispositivo.getTipo().getCodigo()));
			
		} catch (MyDaoExeption e) {
			// TODO: handle exception
			fail(e.getMessage());
		}
	}

}
