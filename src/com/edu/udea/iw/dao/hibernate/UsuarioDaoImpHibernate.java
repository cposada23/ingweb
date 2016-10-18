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

	@Override
	public Usuario obtenerPorCedula(String cedula) throws MyDaoExeption {
		Session session = null;
		Usuario usuario = null;
		
		try {
			session = sessionFactory.openSession();
			usuario = (Usuario) session.get(Usuario.class, cedula);
			if(usuario == null){
				throw new MyDaoExeption("Usuario no encontrado", null);
			}
			return usuario;
		} catch (HibernateException  e) {
			throw new MyDaoExeption("Usuario no encontrado", null);
		}
		
	}

	@Override
	public void guardar(Usuario usuario) throws MyDaoExeption {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(usuario); 
			//transaction.commit();
		} catch (HibernateException	 e) {
			throw new MyDaoExeption(e);
		}
		
	}

	@Override
	public void actualizar(Usuario usuario) throws MyDaoExeption {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(usuario);
			transaction.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			throw new MyDaoExeption(e);
		}
		
	}


	

	

}
