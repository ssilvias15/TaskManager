package ie.silvia.dao.impl;

import ie.silvia.dao.GenericDaoHibernateImpl;
import ie.silvia.model.Users;

public class DAOUsers extends GenericDaoHibernateImpl<Users, Integer>{

	public DAOUsers() {
		super(Users.class);
	}

}

