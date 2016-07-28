package ie.silvia.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import ie.silvia.dao.impl.DAOUsers;
import ie.silvia.model.Users;

public class UsersService {

	private DAOUsers dao = null;
	
	public UsersService(DAOUsers dao){
		this.dao = dao;
	}
	
	public Users getUserFromSecurity(){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername();
		Users currentUser = dao.getUserByUsername(name);
		return currentUser;
	}
}
