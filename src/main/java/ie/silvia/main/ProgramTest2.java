package ie.silvia.main;

import org.hibernate.Session;

import ie.silvia.hibernate.util.HibernateUtil;
import ie.silvia.model.Tasks;
import ie.silvia.model.Users;

public class ProgramTest2 {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		// select
		Users someUser = (Users) session.get(Users.class, 3);
		System.out.println("Found in db: " + someUser.getUsername());
		
		
		for(Tasks t : someUser.getTasksList()){
			System.out.println("Task: " + t.getTaskname());
		}
		
		session.getTransaction().commit();
		session.close();
	}

}
