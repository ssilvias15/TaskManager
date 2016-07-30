package ie.silvia.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ie.silvia.dao.GenericDaoHibernateImpl;
import ie.silvia.model.Comments;
import ie.silvia.model.CommentsComparator;
import ie.silvia.model.Tasks;
import ie.silvia.model.Users;

public class DAOComments extends GenericDaoHibernateImpl<Comments, Integer>{
	
	public DAOComments(){
		super(Comments.class);
	}
	
	public List<Comments> findMostRecentComments(Users currentUser, DAOTasks daoTasks){
		List<Comments> comments = new ArrayList<>();
		
		List<Tasks> allUserTasks = daoTasks.getTasksByUserId(currentUser);
		for(Tasks t : allUserTasks){
			List<Comments> allComs = t.getCommentsList();
			comments.addAll(allComs);
		}
		Collections.sort(comments, new CommentsComparator());
		return comments;
	}

}
