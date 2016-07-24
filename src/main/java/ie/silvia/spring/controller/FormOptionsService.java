package ie.silvia.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ie.silvia.dao.impl.DAOCategories;
import ie.silvia.dao.impl.DAOPriority;
import ie.silvia.dao.impl.DAOStatus;
import ie.silvia.dao.impl.DAOTasks;
import ie.silvia.dao.impl.DAOUsers;
import ie.silvia.model.Categories;
import ie.silvia.model.Priority;
import ie.silvia.model.Status;
import ie.silvia.model.Users;

public class FormOptionsService {

	private DAOCategories daoCategories;
	private DAOUsers daoUsers;
	private DAOPriority daoPriority;
	private DAOStatus daoStatus;
	
	public FormOptionsService(){
		daoCategories = new DAOCategories();
		daoUsers = new DAOUsers();
		daoPriority = new DAOPriority();
		daoStatus = new DAOStatus();
	}
	
	

	public FormOptionsService(DAOCategories daoCategories, DAOUsers daoUsers, DAOPriority daoPriority,
			DAOStatus daoStatus) {
		this.daoCategories = daoCategories;
		this.daoUsers = daoUsers;
		this.daoPriority = daoPriority;
		this.daoStatus = daoStatus;
	}



	public Map<Integer, String> getPriorityOptions() {
		List<Priority> priorities = daoPriority.findAll();
		Map<Integer, String> options = new HashMap<>();
		for (Priority priority : priorities) {
			options.put(priority.getId(), priority.getPriorname());
		}
		return options;
	}

	public Map<Integer, String> getCategoryOptions() {

		Map<Integer, String> options = new HashMap<>();
		List<Categories> categories = daoCategories.findAll();
		for (Categories cat : categories) {
			options.put(cat.getId(), cat.getCatname());
		}
		return options;
	}

	public Map<Integer, String> getStatusOptions() {
		List<Status> statuses = daoStatus.findAll();
		Map<Integer, String> options = new HashMap<>();
		for (Status status : statuses) {
			options.put(status.getId(), status.getStatusname());
		}
		return options;

	}

	public Map<Integer, String> getUserOptions() {

		List<Users> users = daoUsers.findAll();

		Map<Integer, String> userOptions = new HashMap<>();
		for (Users user : users) {
			userOptions.put(user.getId(), user.getUsername());
		}

		return userOptions;
	}

}
