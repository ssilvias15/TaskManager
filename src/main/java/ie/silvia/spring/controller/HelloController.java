package ie.silvia.spring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ie.silvia.dao.impl.DAOTasks;
import ie.silvia.model.Tasks;

@Controller
public class HelloController {

	private DAOTasks dao = new DAOTasks();
	
	public HelloController(){
		System.out.println("CREATING CONTROLLER");
	}
	
	@RequestMapping(value="/index.htm", method=RequestMethod.GET)
	public ModelAndView helloMethod(){
		List<Tasks> allTasks = dao.findAll();
		 ModelAndView mav = new ModelAndView("index");
		 mav.addObject("TASKS", allTasks);
		return mav;
	}
	
	
	@RequestMapping(value="/mytasks.htm", method=RequestMethod.GET)
	public ModelAndView pizzaMethod(){
		return new ModelAndView("mytasks");  // WEB-INF/jsp/mytasks.jsp
	}
	
	@RequestMapping(value="/create.htm", method = RequestMethod.GET)
	public ModelAndView task(){
		ModelAndView mav = new ModelAndView("create", "command", new Tasks());
		
		return mav;
	}
	
	/*
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}

		model.setViewName("login");
		return model;
	}*/


	
	@RequestMapping(value = "/save.htm", method=RequestMethod.POST)
	public ModelAndView saveTask(@ModelAttribute("task")Tasks task){
		ModelAndView mav = new ModelAndView("redirect:/index.htm");
		System.out.println("Saving task!!! "  + task);
		dao.create(task);
		
		return mav;
	}
}

