package ie.silvia.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import ie.silvia.hibernate.util.HibernateUtil;



public class GenericDaoHibernateImpl<T, PK extends Serializable> implements GenericDao<T, PK> {
	private Class<T> type;

	public GenericDaoHibernateImpl(Class<T> type) {
		this.type = type;
	}

	public PK create(T o) {
		
		Session session = getSession();
		session.beginTransaction();
		PK pk = (PK)session.save(o);
		session.getTransaction().commit();
		session.close();
		return pk;
	}

	public T read(PK id) {
		Session session = getSession();
		T obiect = (T) session.get(type, id);
		session.close();
		return obiect;

	
	}
	
	
	public List<T> findAll() {
		Session session = getSession();
		List<T> toate =  session.createCriteria(type).list();
		session.close();
		return toate;
	
	}

	public void update(T o) {
		Session session = getSession();
		session.beginTransaction();
		session.update(o);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(T o) {
		Session session = getSession();
		session.beginTransaction();
		session.delete(o);
		session.getTransaction().commit();
		session.close();
	}

	public Session getSession() {
		return HibernateUtil.getSessionFactory().openSession();
	}

}