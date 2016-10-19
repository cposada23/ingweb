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
import com.edu.udea.iw.dao.PrestamoDao;
import com.edu.udea.iw.dto.Dispositivo;
import com.edu.udea.iw.dto.Prestamo;
import com.edu.udea.iw.dto.Tipo;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations=("classpath:configuracion.xml"))
public class PrestamoDaoTestCase {

	
	@Autowired
	PrestamoDao prestamoDao;
	
	@Test
	public void testGetDispositivos() {
		List<Prestamo> prestamos = null;
		try{
			
			prestamos = prestamoDao.obtener();
			if(prestamos.size()>0){
				for (Prestamo prestamo: prestamos){
					System.out.println(prestamo.getCodigo()+ "," + prestamo.getFechaInicio());
				}
			}
			assertTrue(prestamos.size()> 0);
			
		}catch (MyDaoExeption e) {
			//System.out.println(e.getMessage());
			fail(e.getMessage());
			
		}
		
	}


}
