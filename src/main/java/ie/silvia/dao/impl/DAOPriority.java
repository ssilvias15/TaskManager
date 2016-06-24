package ie.silvia.dao.impl;

import ie.silvia.dao.GenericDaoHibernateImpl;
import ie.silvia.model.Priority;

public class DAOPriority extends GenericDaoHibernateImpl<Priority, Integer>{

	public DAOPriority() {
		super(Priority.class);
	}

}