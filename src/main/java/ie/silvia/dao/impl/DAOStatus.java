package ie.silvia.dao.impl;

import ie.silvia.dao.GenericDaoHibernateImpl;
import ie.silvia.model.Status;

public class DAOStatus extends GenericDaoHibernateImpl<Status, Integer>{

	public DAOStatus() {
		super(Status.class);
	}

}