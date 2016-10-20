package com.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.edu.udea.iw.dao.DispositivoDao;
import com.edu.udea.iw.dto.Dispositivo;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;

public class DispositivoDaoImp implements DispositivoDao {

	private SessionFactory sessionFactory; 
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
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

}
