package ie.silvia.main;

import org.hibernate.Session;

import ie.silvia.hibernate.util.HibernateUtil;
import ie.silvia.model.Tasks;
import ie.silvia.model.Users;

public class ProgramTest {

	public static void main(String[] args) {
		// session este un fel de Connection
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Users user1 = new Users();
		user1.setUsername("Jack");
		user1.setPassword("1234");
		
		Users user2 = new Users();
		user2.setUsername("Stanley");
		user2.setPassword("mask");
		
		Tasks task1 = new Tasks();
		task1.setContent("implement unit testing");
		task1.setTaskname("jUnit testing");
		task1.setUserid(user1);
		
		
		session.saveOrUpdate(user1);
		session.saveOrUpdate(user2);
		session.saveOrUpdate(task1);
		
		session.getTransaction().commit();
		session.close();

	}

}
