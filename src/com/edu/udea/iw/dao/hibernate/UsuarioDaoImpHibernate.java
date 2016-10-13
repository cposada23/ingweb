package com.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.edu.udea.iw.dao.UsuarioDao;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;

public class UsuarioDaoImpHibernate implements UsuarioDao {

	
	private SessionFactory sessionFactory; 
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<Usuario> obtener() throws MyDaoExeption {
		Session session = null;
		List<Usuario> usuarios = null;
		
		try {
			session = sessionFactory.openSession();
			Criteria criteria =  session.createCriteria(Usuario.class);
			usuarios = criteria.list();
		} catch (HibernateException	 e) {
			throw new MyDaoExeption(e);
		}
		
		return usuarios;
	}


	

	

}
