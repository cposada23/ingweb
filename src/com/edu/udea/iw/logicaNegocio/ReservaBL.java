package com.edu.udea.iw.logicaNegocio;

import java.util.Date;
import java.util.List;

import com.edu.udea.iw.dto.Reserva;
import com.edu.udea.iw.exeption.MyDaoExeption;

public interface ReservaBL {
	
	
	public void crearReserva(String usuarioReserva, Date fechaReserva, int dispositivo) throws MyDaoExeption;

	public List<Reserva> buscarReserva(String usuarioReserva) throws MyDaoExeption;
	
}
