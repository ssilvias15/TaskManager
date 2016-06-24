package ie.silvia.dao.impl;

import ie.silvia.dao.GenericDaoHibernateImpl;
import ie.silvia.model.Tags;

public class DAOTags extends GenericDaoHibernateImpl<Tags, Integer>{

	public DAOTags() {
		super(Tags.class);
	}

}