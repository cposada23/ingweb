package com.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.edu.udea.iw.dao.DispositivoDao;
import com.edu.udea.iw.dto.Dispositivo;
import com.edu.udea.iw.dto.Tipo;
import com.edu.udea.iw.exeption.MyDaoExeption;
/**
 * Clase Hibernate de Dispositivo que implementa la interfaz DispositivoDao
 * @author Camilo Posada Angel - cposadaa@gmail.com
 */
public class DispositivoDaoImp implements DispositivoDao {

	private SessionFactory sessionFactory; 
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * Metodo que abre la conexion con la sessionFactory que por medio del fichero de mapeo de hibernate de dispositivo
	 * Accede a todos los dispositivos que se encuentran registrados en la base de datos.
	 * @return Todos los dispositivos registrados en el sistema
	 * @throws MyDaoExeption
	 */
	@Override
	public List<Dispositivo> getDispositivos() throws MyDaoExeption {
		Session session = null;
		List<Dispositivo> dipositivos = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Dispositivo.class);
			dipositivos = criteria.list();
		} catch (HibernateException e) {
			throw new MyDaoExeption(e);
		}
		return dipositivos;
	}

	/**
	 * Metodo que por medio de la conexion con la sessionFactory crea un nuevo dispositivo en la base de datos
	 * @param dispositivo
	 * @return 
	 * @throws MyDaoExeption
	 */
	@Override
	public void crear(Dispositivo dispositivo) throws MyDaoExeption {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(dispositivo); 
			//transaction.commit();
		} catch (HibernateException	 e) {
			throw new MyDaoExeption(e);
		}
		
	}
	
	/**
	 * Metodo que busca un dispositivo en la base de datos por medio de su codigo
	 * @param codigo
	 * @return dispositivo
	 * @throws MyDaoExeption
	 */
	@Override
	public Dispositivo obtenerPorCodigo(int codigo) throws MyDaoExeption {
		Session session = null;
		Dispositivo dispositivo = null;
		try {
			session = sessionFactory.openSession();
			dispositivo = (Dispositivo) session.get(Dispositivo.class, codigo);
		} catch (HibernateException e) {
			throw new MyDaoExeption(e);
		}
		return dispositivo;
	}

	@Override
	public void actualizar(Dispositivo dispositivo) throws MyDaoExeption {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(dispositivo);
			//transaction.commit();
		} catch (HibernateException e) {
			throw new MyDaoExeption(e);
		}
		
	}

	@Override
	public List<Dispositivo> listarDispositivosDisponibles(Tipo tipo) throws MyDaoExeption {
		
		Session session = null;
		List<Dispositivo> dispositivos = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Dispositivo.class).add(Restrictions.eq("tipo", tipo));
			dispositivos = criteria.list();
		} catch (HibernateException e) {
			throw new MyDaoExeption(e);
		}
		return dispositivos;
	}

	@Override
	public List<Dispositivo> listarDiposnibles() throws MyDaoExeption {
		
		Session session = null;
		List<Dispositivo> dispositivos = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Dispositivo.class).add(Restrictions.eq("estado", true));
			dispositivos = criteria.list();
		} catch (HibernateException e) {
			throw new MyDaoExeption(e);
		}
		return dispositivos;
	}

	
	
}
