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
		// load associated comments
		
		for(Tasks t : tasksForUser){
			// test
			t.getCommentsList();
		}
		System.out.println("TASKS FOR CURRENT USER: " + tasksForUser);
		return tasksForUser;
	}
	
	public Tasks getTaskWithComments(Integer taskId){
		Tasks task = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		task = (Tasks)session.get(Tasks.class, taskId);
		// also load the comments
		task.getCommentsList();
		
		
		return task;
		
	}
	
	public static void main(String[] args) {
		DAOUsers daoUsers = new DAOUsers();
		DAOTasks daoTasks = new DAOTasks();
		
		Tasks someTask = daoTasks.getTaskWithComments(14);
		System.out.println(someTask.getTaskname());
		System.out.println(someTask.getCommentsList());
	}

}
