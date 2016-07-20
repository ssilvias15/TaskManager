package ie.silvia.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ie.silvia.dao.impl.DAOCategories;
import ie.silvia.dao.impl.DAOPriority;
import ie.silvia.dao.impl.DAOTasks;
import ie.silvia.dao.impl.DAOUsers;
import ie.silvia.model.Categories;
import ie.silvia.model.Priority;
import ie.silvia.model.Tasks;
import ie.silvia.model.Users;

@Controller
public class HelloController {

	private DAOTasks dao = new DAOTasks();
	private DAOCategories daoCategories = new DAOCategories();
	private DAOUsers daoUsers = new DAOUsers();
	private DAOPriority daoPriority = new DAOPriority();
	
	public HelloController(){
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
		return new ModelAndView("mytasks");  // WEB-INF/jsp/mytasks.jsp
	}
	
	
	@RequestMapping(value="/create.htm", method = RequestMethod.GET)
	public ModelAndView task(){
		ModelAndView mav = new ModelAndView("create", "command", new Tasks());
		
		List<Categories> categories = daoCategories.findAll();
		List<Users> users = daoUsers.findAll();
		List<Priority> priorities = daoPriority.findAll(); 
		Map<Integer, String> options = new HashMap<>();
		for(Categories cat : categories){
			options.put(cat.getId(), cat.getCatname());
		}
		Map<Integer, String> userOptions = new HashMap<>();
		for(Users user : users){
			userOptions.put(user.getId(), user.getUsername());
		}
		Map<Integer, String> priorityOptions = new HashMap<>();
		for(Priority priority : priorities){
			priorityOptions.put(priority.getId(), priority.getPriorname());
		}
		mav.addObject("OPTIONS", options);
		mav.addObject("USER_OPTIONS", userOptions);
		mav.addObject("PRIORITY_OPTIONS", priorityOptions);
		return mav;
	}

	
	@RequestMapping(value = "/save.htm", method=RequestMethod.POST)
	public ModelAndView saveTask(@ModelAttribute("task")Tasks task){
		ModelAndView mav = new ModelAndView("redirect:/index.htm?tasksaved=ok");
		// task.setCatid(catid);
		Categories cat = daoCategories.read(task.getCategoryId());
		task.setCatid(cat);
		Users associatedUser = daoUsers.read(task.getUserSpringIdentifier());
		task.setUserid(associatedUser);
		
		Priority priority = daoPriority.read(task.getPrioritySpringIdentifier());
		task.setPriorityid(priority);
		System.out.println("Saving task!!! "  + task);
		System.out.println("ASSOCIATED CATEGORY: " + task.getCatid());
		dao.create(task);
		
		return mav;
	}
}

