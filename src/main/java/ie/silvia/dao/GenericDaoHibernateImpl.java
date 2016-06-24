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
		PK primaryKey = (PK)session.save(o);
		session.getTransaction().commit();
		session.close();
		return primaryKey;
	}

	public T read(PK id) {
		Session session = getSession();
		T obj = (T) session.get(type, id);
		session.close();
		return obj;

	
	}
	
	
	public List<T> findAll() {
		Session session = getSession();
		List<T> everyItem =  session.createCriteria(type).list();
		session.close();
		return everyItem;
	
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