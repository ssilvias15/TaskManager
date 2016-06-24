package ie.silvia.dao.impl;

import ie.silvia.dao.GenericDaoHibernateImpl;
import ie.silvia.model.Comments;

public class DAOComments extends GenericDaoHibernateImpl<Comments, Integer>{
	
	public DAOComments(){
		super(Comments.class);
	}

}
