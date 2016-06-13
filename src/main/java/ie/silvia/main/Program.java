package ie.silvia.main;

import org.hibernate.Session;

import ie.silvia.hibernate.util.HibernateUtil;
import ie.silvia.model.Categories;
import ie.silvia.model.Status;

public class Program {

	public static void main(String[] args) {
//		Category cat = new Category();
//		Category cat2 = new Category("Bug");
//		Category cat3 = new Category(103, "Issue");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Categories firstCat = (Categories)session.get(Categories.class, 3);
		System.out.println("FIRST CATEGORY: " + firstCat.getCatname());
		
		System.out.println("Saving new status");
		Status stat = new Status();
		stat.setStatusname("Open");
		
		
		session.save(stat);
		session.getTransaction().commit();
		
	}
}
