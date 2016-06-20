package ie.silvia.dao.impl;

import ie.silvia.dao.GenericDaoHibernateImpl;
import ie.silvia.model.Tasks;

public class DAOTasks extends GenericDaoHibernateImpl<Tasks, Integer>{

	public DAOTasks() {
		super(Tasks.class);
	}

}
