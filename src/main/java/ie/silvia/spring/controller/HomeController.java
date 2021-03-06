package ie.silvia.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ie.silvia.dao.impl.DAOCategories;
import ie.silvia.dao.impl.DAOComments;
import ie.silvia.dao.impl.DAOPriority;
import ie.silvia.dao.impl.DAOStatus;
import ie.silvia.dao.impl.DAOTasks;
import ie.silvia.dao.impl.DAOUsers;
import ie.silvia.model.Categories;
import ie.silvia.model.Comments;
import ie.silvia.model.Priority;
import ie.silvia.model.Status;
import ie.silvia.model.Tasks;
import ie.silvia.model.Users;
import ie.silvia.service.UsersService;

@Controller
public class HomeController {

	private DAOTasks dao = new DAOTasks();
	private DAOCategories daoCategories = new DAOCategories();
	private DAOUsers daoUsers = new DAOUsers();
	private DAOPriority daoPriority = new DAOPriority();
	private DAOStatus daoStatus = new DAOStatus();
	private UsersService usersService = new UsersService(daoUsers);
	private DAOComments daoComment = new DAOComments();
	
	private static final int NUMBER_OF_RECENT_TASKS = 7;
	
	public HomeController(){
		System.out.println("CREATING CONTROLLER");
	}
	
	@RequestMapping(value="/recenttasks.htm", method=RequestMethod.GET)
	public ModelAndView recentTasks(){
		
		List<Tasks> allTasks = dao.findAll();
		
		List<Tasks> recentTasks = null;
		if(allTasks.size() > NUMBER_OF_RECENT_TASKS){
			recentTasks = allTasks.subList(0, NUMBER_OF_RECENT_TASKS-1);
		}else{
			recentTasks = allTasks;
		}
		
		 ModelAndView mav = new ModelAndView("tasks/recenttasks");
		 mav.addObject("TASKS", recentTasks);
		return mav;
	}
	
	@RequestMapping(value="/index.htm", method=RequestMethod.GET)
	public ModelAndView landingPage(){
		
		// page where we view most recent tasks
		// and most recent comments associated to our tasks
		List<Tasks> allTasks = dao.findAll();
		
		List<Tasks> recentTasks = null;
		if(allTasks.size() > 5){
			recentTasks = allTasks.subList(0, 4);
		}else{
			recentTasks = allTasks;
		}
		
		Users currentUser = usersService.getUserFromSecurity();
		List<Comments> recentComments = daoComment.findMostRecentComments(currentUser, dao);
		 ModelAndView mav = new ModelAndView("index");
		 mav.addObject("TASKS", recentTasks);
		 mav.addObject("RECENT_COMMENTS", recentComments);
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
	public ModelAndView viewMyTasks(@RequestParam(value = "filterPriority", required = false) Integer priorityFilterId){
		ModelAndView mav = new ModelAndView("mytasks");
		Users currentUser = usersService.getUserFromSecurity();
		List<Priority> priorities = daoPriority.findAll();
		List<Tasks> specificPriorities = new ArrayList<>();
		List<Tasks> tasks = dao.getTasksByUserId(currentUser);
		if(priorityFilterId != null){
			for(Tasks task : tasks){
				if(task.getPriorityid() != null && task.getPriorityid().getId() != null && task.getPriorityid().getId().equals(priorityFilterId)){
					specificPriorities.add(task);
				}
			}
		}
		
		if(priorityFilterId != null){
			tasks = specificPriorities;
		}
		mav.addObject("CURRENT_USER", currentUser);
		mav.addObject("MY_TASKS", tasks);
		mav.addObject("PRIORITIES", priorities);
		return mav;  
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

