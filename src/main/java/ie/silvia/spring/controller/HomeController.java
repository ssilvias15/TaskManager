package ie.silvia.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ie.silvia.dao.impl.DAOCategories;
import ie.silvia.dao.impl.DAOPriority;
import ie.silvia.dao.impl.DAOStatus;
import ie.silvia.dao.impl.DAOTasks;
import ie.silvia.dao.impl.DAOUsers;
import ie.silvia.model.Categories;
import ie.silvia.model.Priority;
import ie.silvia.model.Status;
import ie.silvia.model.Tasks;
import ie.silvia.model.Users;

@Controller
public class HomeController {

	private DAOTasks dao = new DAOTasks();
	private DAOCategories daoCategories = new DAOCategories();
	private DAOUsers daoUsers = new DAOUsers();
	private DAOPriority daoPriority = new DAOPriority();
	private DAOStatus daoStatus = new DAOStatus();
	
	public HomeController(){
		System.out.println("CREATING CONTROLLER");
	}
	
	@RequestMapping(value="/index.htm", method=RequestMethod.GET)
	public ModelAndView viewRecentTasks(){
		List<Tasks> allTasks = dao.findAll();
		
		List<Tasks> recentTasks = null;
		if(allTasks.size() > 5){
			recentTasks = allTasks.subList(0, 4);
		}else{
			recentTasks = allTasks;
		}
		 ModelAndView mav = new ModelAndView("index");
		 mav.addObject("TASKS", recentTasks);
		return mav;
	}
	
	@RequestMapping(value="/alltasks.htm", method=RequestMethod.GET)
	public ModelAndView viewAllTasks(){
		List<Tasks> allTasks = dao.findAll();
		 ModelAndView mav = new ModelAndView("alltasks");
		 mav.addObject("TASKS", allTasks);
		return mav;
	}
	
	
	@RequestMapping(value="/mytasks.htm", method=RequestMethod.GET)
	public ModelAndView viewMyTasks(){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername();
		System.out.println("CURRENT USER USERNAME: " + name);
		ModelAndView mav = new ModelAndView("mytasks");
		// find the tasks for the currently logged in user
		Users currentUser = daoUsers.getUserByUsername(name);
		List<Tasks> tasks = dao.getTasksByUserId(currentUser);
		mav.addObject("CURRENT_USER", currentUser);
		mav.addObject("MY_TASKS", tasks);
		return mav;  // WEB-INF/jsp/mytasks.jsp
	}
	
	
	
	@RequestMapping(value="/create.htm", method = RequestMethod.GET)
	public ModelAndView task(){
		ModelAndView mav = new ModelAndView("create", "command", new Tasks());
		FormOptionsService fos = new FormOptionsService(daoCategories, daoUsers, daoPriority, daoStatus);
		// TODO: cp1
		Map<Integer, String> categoryOptions = fos.getCategoryOptions();
		Map<Integer, String> userOptions = fos.getUserOptions();
		Map<Integer, String> priorityOptions = fos.getPriorityOptions();
		Map<Integer, String> statusOptions = fos.getStatusOptions();
		
		mav.addObject("OPTIONS", categoryOptions);
		mav.addObject("USER_OPTIONS", userOptions);
		mav.addObject("PRIORITY_OPTIONS", priorityOptions);
		mav.addObject("STATUS_OPTIONS", statusOptions);
		
		// /cp1
		return mav;
	}

	@RequestMapping(value = "/save.htm", method=RequestMethod.POST)
	public ModelAndView saveTask(@ModelAttribute("task")Tasks task, @RequestParam("newtask") Boolean newTask){
		ModelAndView mav = new ModelAndView("redirect:/index.htm?tasksaved=ok");
		Categories cat = daoCategories.read(task.getCategoryId());
		task.setCatid(cat);
		Users associatedUser = daoUsers.read(task.getUserSpringIdentifier());
		task.setUserid(associatedUser);
		
		Priority priority = daoPriority.read(task.getPrioritySpringIdentifier());
		task.setPriorityid(priority);
		
		Status status = daoStatus.read(task.getStatusSpringIdentifier());
		task.setStatusid(status);
		System.out.println("Saving task!!! "  + task);
		System.out.println("ASSOCIATED CATEGORY: " + task.getCatid());
		if(newTask){
			dao.create(task);
		}else{
			dao.update(task);
		}
		
		return mav;
	}
}

