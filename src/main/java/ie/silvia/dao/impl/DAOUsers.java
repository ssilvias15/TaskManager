package ie.silvia.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import ie.silvia.dao.GenericDaoHibernateImpl;
import ie.silvia.hibernate.util.HibernateUtil;
import ie.silvia.model.Users;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

public class DAOUsers extends GenericDaoHibernateImpl<Users, Integer>{

	public DAOUsers() {
		super(Users.class);
	}
	
	public Users getUserByUsername(String username){
		Users user = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Users.class);

		user = (Users) criteria.add(Restrictions.eq("username", username)).uniqueResult();

		return user;
	}

	public static void main(String[] args) {
		System.out.println("USER: ");
		DAOUsers dao = new DAOUsers();
		Users user = dao.getUserByUsername("silvia");
		System.out.println("USER: " + user.getUsername()  + " " + user.getPassword());
	}
}

