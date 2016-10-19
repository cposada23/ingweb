package com.edu.udea.iw.dao.hibernate;
/**
 * @author Andersson villa
 */

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.edu.udea.iw.dao.PrestamoDao;
import com.edu.udea.iw.dto.Prestamo;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;

public class PrestamoDaoImpHibernate implements PrestamoDao {

	
	private SessionFactory sessionFactory; 
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public List<Prestamo> obtenerPrestamos() throws MyDaoExeption {
		Session session = null;
		List<Prestamo> prestamos = null;
		
		try {
			session = sessionFactory.openSession();
			Criteria criteria =  session.createCriteria(Prestamo.class);
			prestamos = criteria.list();
		} catch (HibernateException	 e) {
			throw new MyDaoExeption(e);
		}
		
		return prestamos;
	}

	@Override
	public Prestamo obtenerPrestamo(int id) throws MyDaoExeption {
		Session session = null;
		Prestamo prestamo = null;
		
		try {
			session = sessionFactory.openSession();
			prestamo = (Prestamo) session.get(Prestamo.class, id);
			
			return prestamo;
		} catch (HibernateException  e) {
			throw new MyDaoExeption("Prestamo no encontrado", null);
		}
	}

	@Override
	public void crearPrestamo(Prestamo prestamo) throws MyDaoExeption {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(prestamo); 
			//transaction.commit();
		} catch (HibernateException	 e) {
			throw new MyDaoExeption(e);
		}
		
	}

	@Override
	public void actualizarPrestamo(Prestamo prestamo) throws MyDaoExeption {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(prestamo);
			transaction.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			throw new MyDaoExeption(e);
		}
		
	}

	@Override
	public void eliminarPrestamo(Prestamo prestamo) throws MyDaoExeption {
		// TODO Auto-generated method stub
		
	}




	

	

}
