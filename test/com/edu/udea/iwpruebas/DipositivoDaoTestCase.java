package com.edu.udea.iwpruebas;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.dao.DispositivoDao;
import com.edu.udea.iw.dto.Dispositivo;
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

}
