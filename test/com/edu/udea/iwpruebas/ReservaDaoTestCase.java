package com.edu.udea.iwpruebas;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.dao.ReservaDao;
import com.edu.udea.iw.dto.Reserva;
import com.edu.udea.iw.exeption.MyDaoExeption;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations=("classpath:configuracion.xml"))

public class ReservaDaoTestCase {

	@Autowired
	ReservaDao reservaDao;
	
	@Test
	public void testObtener() {
		List<Reserva> reservas = null;
		try {
			reservas = reservaDao.obtener();
			if(reservas.size()> 0){
				for(Reserva reserva:reservas){
					System.out.println(reserva.getCodigo());
				}
			}
			assertTrue(reservas.size()>0);
		} catch (MyDaoExeption e) {
			fail(e.getMessage());
		}
	}

}
