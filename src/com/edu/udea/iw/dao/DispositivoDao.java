package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Dispositivo;
import com.edu.udea.iw.dto.Tipo;
import com.edu.udea.iw.exeption.MyDaoExeption;
import com.mysql.jdbc.exceptions.MySQLDataException;
/**
 * Interface de Dispositivo 
 * @author  Camilo Posada Angel - cposadaa@gmail.com
 */
public interface DispositivoDao {
	
	
	/**
	 * Lista con todos los dispositivos registrados en la base de datos
	 * @return
	 * @throws MyDaoExeption
	 */
	public List<Dispositivo> getDispositivos() throws MyDaoExeption;
	
	
	/**
	 * Metodo que crea un nuevo dispositivo en la base de datos
	 * @param dispositivo
	 * @throws MyDaoExeption
	 */
	public void crear(Dispositivo dispositivo) throws MyDaoExeption;
	
	/**
	 * Metodo que busca un dispositivo por medio de su codigo
	 * @param codigo
	 * @return
	 * @throws MyDaoExeption
	 */
	public Dispositivo obtenerPorCodigo(int codigo) throws MyDaoExeption;
	
	/**
	 * Actualiza los datos de un dispositivo
	 * @param dispositivo
	 * @throws MyDaoExeption
	 */
	public void actualizar(Dispositivo dispositivo) throws MyDaoExeption;
	
	/**
	 * Lista todos los dispositivos diponibles de un tipo dado
	 * por ejemplo todos los microscopios disponibles
	 * @param tipo
	 * @return
	 * @throws MyDaoExeption
	 */
	
	public List<Dispositivo> listarDispositivosDisponibles(Tipo tipo) throws MyDaoExeption;
	
	
	/**
	 * Lista todos los dispositivos disponibles de la base de datos
	 * @return
	 * @throws MyDaoExeption
	 */
	public List<Dispositivo> listarDiposnibles() throws MyDaoExeption;

}
