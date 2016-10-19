package com.edu.udea.iw.logicaNegocio;

import com.edu.udea.iw.exeption.MyDaoExeption;

public interface DispositivoBL {
	
	
	public void crearDispositivo(int codigo, String descripcion, String usuarioCrea, String tipo)throws MyDaoExeption;
	

}
