package com.edu.udea.iw.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.edu.udea.iw.dao.ReservaDao;
import com.edu.udea.iw.dto.Prestamo;
import com.edu.udea.iw.dto.Reserva;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;

public class ReservaDaoImpHibernate implements ReservaDao {

	
	private SessionFactory sessionFactory; 
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<Reserva> obtenerReservas() throws MyDaoExeption {
		Session session = null;
		List<Reserva> reservas = null;
		
		try {
			session = sessionFactory.openSession();
			Criteria criteria =  session.createCriteria(Reserva.class);
			reservas = criteria.list();
		} catch (HibernateException	 e) {
			throw new MyDaoExeption(e);
		}
		
		return reservas;
	}

	@Override
	public Reserva obtenerPrestamo(int id) throws MyDaoExeption {
		Session session = null;
		Reserva reserva = null;
		
		try {
			session = sessionFactory.openSession();
			reserva = (Reserva) session.get(Reserva.class, id);
			
			return reserva;
		} catch (HibernateException  e) {
			throw new MyDaoExeption("Prestamo no encontrado", null);
		}
	}

	@Override
	public void actualizarReserva(Reserva reserva) throws MyDaoExeption {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(reserva);
			transaction.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			throw new MyDaoExeption(e);
		}
		
	}

	@Override
	public void eliminarReserva(Reserva reserva) throws MyDaoExeption {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crearReserva(Reserva reserva) throws MyDaoExeption {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(reserva); 
			//transaction.commit();
		} catch (HibernateException	 e) {
			throw new MyDaoExeption(e);
		}
		
	}

	@Override
	public List<Reserva> obtenerReservasNoAprobadas() throws MyDaoExeption {
		Session session = null;
		List<Reserva> reserva = null;
		
		try {
			session = sessionFactory.openSession();
			Criteria criteria =  session.createCriteria(Reserva.class).add(Restrictions.eq("Aprobado", 0));
			reserva = criteria.list();
			return reserva;
		} catch (HibernateException  e) {
			throw new MyDaoExeption("Prestamo no encontrado", null);
		}
	}

	@Override
	public List<Reserva> ObtenerReservaPorUsuario(Usuario usuario) throws MyDaoExeption {
		Session session = null;
		List<Reserva> reserva = null;
		
		try {
			session = sessionFactory.openSession();
			Criteria criteria =  session.createCriteria(Reserva.class).add(Restrictions.eq("usuarioReserva", usuario));
			reserva = criteria.list();
			
		} catch (HibernateException  e) {
			throw new MyDaoExeption("Reserva no encontrado", null);
		}
		return reserva;
	}




	

	

}
