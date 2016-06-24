package ie.silvia.dao.impl;

import ie.silvia.dao.GenericDaoHibernateImpl;
import ie.silvia.model.Categories;

public class DAOCategories extends GenericDaoHibernateImpl<Categories, Integer>{

	public DAOCategories() {
		super(Categories.class);

	}

}
