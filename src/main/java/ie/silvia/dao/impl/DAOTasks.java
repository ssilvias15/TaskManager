package ie.silvia.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import ie.silvia.dao.GenericDaoHibernateImpl;
import ie.silvia.hibernate.util.HibernateUtil;
import ie.silvia.model.Tasks;
import ie.silvia.model.Users;

public class DAOTasks extends GenericDaoHibernateImpl<Tasks, Integer>{

	public DAOTasks() {
		super(Tasks.class);
	}

	
	public List<Tasks> getTasksByUserId(Users user){
		List<Tasks> tasksForUser = new ArrayList<>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Tasks.class);
		System.out.println("FINDING ALL TASKS");
		tasksForUser = (List<Tasks>) criteria.add(Restrictions.eq("userid", user)).list();
		System.out.println("TASKS FOR CURRENT USER: " + tasksForUser);
		return tasksForUser;
	}
	
	public static void main(String[] args) {
		DAOUsers daoUsers = new DAOUsers();
		DAOTasks daoTasks = new DAOTasks();
		Users someUser = daoUsers.read(3);
		System.out.println("USER: " + someUser);
		List<Tasks> myTasks = daoTasks.getTasksByUserId(someUser);
		System.out.println("MY TASKS: " + myTasks);
	}

}
