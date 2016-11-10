package com.edu.udea.iw.logicaNegocio;

import java.util.List;

import com.edu.udea.iw.dto.Dispositivo;
import com.edu.udea.iw.exeption.MyDaoExeption;
/**
 * Interface de Dispositivo para la logica del negocio
 * @author Camilo Posada Angel 
 */
public interface DispositivoBL {
	
	
	
	
	/**
	 * Para crear un nuevo dispositivo en la base de datos
	 * @param codigo
	 * @param descripcion
	 * @param usuarioCrea
	 * @param tipo
	 * @throws MyDaoExeption
	 */
	public void crearDispositivo(int codigo, String descripcion, String usuarioCrea, String tipo)throws MyDaoExeption;
	
	
	/**
	 * Actualiza los datos de un dispositivo
	 * @param usuarioActualiza
	 * @param dispositivo
	 * @throws MyDaoExeption
	 */
	public void actualizarDatos(String usuarioActualiza, Dispositivo dispositivo) throws MyDaoExeption;
	
	
	/**
	 * Actualiza la disponibilidad de un dispositivo cuando este es devuelto
	 * @param usuarioActualiza
	 * @param dispositivo
	 * @throws MyDaoExeption
	 */
	public void actualizarDisponibilidad(String usuarioActualiza, Dispositivo dispositivo) throws MyDaoExeption;
	
	/**
	 * pone el estado de eliminado de un dispositivo a true, los registros de los dispositivos no 
	 * son eliminados del todo de la base de datos.
	 * @param usuarioElimina
	 * @param dispositivo
	 * @throws MyDaoExeption
	 */
	public void eliminarDispositivo(String usuarioElimina, Dispositivo dispositivo) throws MyDaoExeption;
	
	
	/**
	 * Logica para buscar un dispositivo en la bd 
	 * @param usuarioBusca
	 * @param codigo
	 * @return
	 * @throws MyDaoExeption
	 */
	public Dispositivo listarDispositivoPorCodigo(String usuarioBusca, int codigo) throws MyDaoExeption;
	
	
	/**
	 * Retorna todos los dispositivos 
	 * @param usuarioBusca
	 * @return lista de dispositivos 
	 * @throws MyDaoExeption 
	 */
	public List<Dispositivo> listarDispositivos(String usuarioBusca) throws MyDaoExeption;
}
