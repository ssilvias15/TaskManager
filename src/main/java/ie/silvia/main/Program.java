package ie.silvia.main;

import org.hibernate.Session;

import ie.silvia.hibernate.util.HibernateUtil;
import ie.silvia.model.Categories;

public class Program {

	public static void main(String[] args) {
//		Category cat = new Category();
//		Category cat2 = new Category("Bug");
//		Category cat3 = new Category(103, "Issue");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Categories firstCat = (Categories)session.get(Categories.class, 2);
		System.out.println("FIRST CATEGORY: " + firstCat.getCatname());
		session.getTransaction().commit();
		
	}
}
