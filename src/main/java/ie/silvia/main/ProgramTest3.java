package ie.silvia.main;

import java.util.List;

import ie.silvia.dao.impl.DAOTags;
import ie.silvia.dao.impl.DAOTasks;
import ie.silvia.dao.impl.DAOUsers;
import ie.silvia.model.Users;

public class ProgramTest3 {

	public static void main(String[] args) {
		DAOUsers dao = new DAOUsers();
		DAOTasks daoT = new DAOTasks();
		DAOTags daoTag = new DAOTags();
		
		
		
		
		Users u1 = dao.read(3);
		System.out.println(u1.getUsername());
		List<Users> allUsers = dao.findAll();
		for(Users u : allUsers){
			System.out.println("USER: " + u.getUsername());
		}
		
		// dao.create(o)
	}
}
