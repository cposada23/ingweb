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
	public List<Prestamo> obtener() throws MyDaoExeption {
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
	public void guardar(Prestamo prestamo) throws MyDaoExeption {
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


	

	

}
