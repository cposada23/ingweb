package com.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.edu.udea.iw.dao.ReservaDao;
import com.edu.udea.iw.dto.Dispositivo;
import com.edu.udea.iw.dto.Reserva;
import com.edu.udea.iw.dto.Usuario;
import com.edu.udea.iw.exeption.MyDaoExeption;
/**
 * Clase Hibernate de Reserva que implementa la interfaz ReservaDao
 * @author Camilo Posada Angel - cposadaa@gmail.com
 */
public class ReservaDaoImpHibernate implements ReservaDao {

	
	private SessionFactory sessionFactory; 
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<Reserva> obtener() throws MyDaoExeption {
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
	public Reserva obtenerReserva(int id) throws MyDaoExeption {
		Session session = null;
		Reserva reserva = null;
		
		try {
			session = sessionFactory.openSession();
			reserva = (Reserva) session.get(Reserva.class, id);
			
			return reserva;
		} catch (HibernateException  e) {
			throw new MyDaoExeption("Reserva no encontrado", null);
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
			Criteria criteria =  session.createCriteria(Reserva.class).add(Restrictions.eq("aprobado", false));
			reserva = criteria.list();
			return reserva;
		} catch (HibernateException  e) {
			throw new MyDaoExeption("No hay reservas no aprobadas", null);
		}
	}

	@Override
	public List<Reserva> ObtenerReservaPorUsuario(Usuario usuario) throws MyDaoExeption {
		Session session = null;
		List<Reserva> reservas = null;
		
		try {
			session = sessionFactory.openSession();
			Criteria criteria =  session.createCriteria(Reserva.class).add(Restrictions.eq("usuarioReserva", usuario));
			reservas = criteria.list();
			
		} catch (HibernateException  e) {
			throw new MyDaoExeption("Reserva no encontrado", null);
		}
		return reservas;
	}

	@Override
	public List<Reserva> obtenerReservasDeDispositivos(Dispositivo dis) throws MyDaoExeption {
		Session session = null;
		List<Reserva> reservas = null;
		
		try {
			session = sessionFactory.openSession();
			Criteria criteria =  session.createCriteria(Reserva.class).add(Restrictions.eq("dispositivo", dis));
			reservas = criteria.list();
			
		} catch (HibernateException  e) {
			throw new MyDaoExeption("Reserva no encontrado", null);
		}
		return reservas;
	
	}


	

	

}
