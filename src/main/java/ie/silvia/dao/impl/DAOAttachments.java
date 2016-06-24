package ie.silvia.dao.impl;

import ie.silvia.dao.GenericDaoHibernateImpl;
import ie.silvia.model.Attachments;

public class DAOAttachments extends GenericDaoHibernateImpl<Attachments, Integer>{
	
	public DAOAttachments(){
		super(Attachments.class);
		
	}
	

}
