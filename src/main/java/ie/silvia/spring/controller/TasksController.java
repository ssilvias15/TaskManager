package ie.silvia.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
import ie.silvia.model.upload.FileBucket;
import ie.silvia.service.UsersService;

@Controller
@RequestMapping("/tasks")
public class TasksController {

	private DAOTasks dao = new DAOTasks();
	private DAOComments daoComments = new DAOComments();
	private DAOCategories daoCategories = new DAOCategories();
	private DAOStatus daoStatuses = new DAOStatus();
	private DAOPriority daoPriorities = new DAOPriority();
	
	private UsersService usersService = new UsersService(new DAOUsers());
	private FormOptionsService fos = new FormOptionsService();

	@RequestMapping(value = "/edit/{taskid}")
	public ModelAndView editTask(@PathVariable("taskid") Integer taskid) {
		Tasks currentTask = dao.read(taskid);
		ModelAndView mav = new ModelAndView("tasks/edit", "command", currentTask);

		Map<Integer, String> categoryOptions = fos.getCategoryOptions();
		Map<Integer, String> userOptions = fos.getUserOptions();
		Map<Integer, String> priorityOptions = fos.getPriorityOptions();
		Map<Integer, String> statusOptions = fos.getStatusOptions();

		mav.addObject("OPTIONS", categoryOptions);
		mav.addObject("USER_OPTIONS", userOptions);
		mav.addObject("PRIORITY_OPTIONS", priorityOptions);
		mav.addObject("STATUS_OPTIONS", statusOptions);

		mav.addObject("taskid", taskid);

		return mav;
	}
	
	
	@RequestMapping(value = "/categories/all")
	public ModelAndView viewAllCategories() {
		List<Categories> cat = daoCategories.findAll();

		ModelAndView mav = new ModelAndView("dashboard/allcategories");
		mav.addObject("CATEGORIES", cat);

		return mav;
	}
	

	@RequestMapping(value = "/statuses/all")
	public ModelAndView viewAllStatuses() {
		List<Status> statuses = daoStatuses.findAll();

		ModelAndView mav = new ModelAndView("dashboard/allstatuses");
		mav.addObject("STATUSES", statuses);

		return mav;
	}
	
	@RequestMapping(value = "/search")
	public ModelAndView search(@RequestParam("query") String query) {
		List<Tasks> allTasks = dao.findAll();
		List<Tasks> foundTasks = new ArrayList<>();
		for(Tasks task : allTasks){
			if(task.getContent() != null && task.getContent().contains(query)){
				foundTasks.add(task);
			}else if(task.getTaskname() != null && task.getTaskname().contains(query)){
				foundTasks.add(task);
			}
		}
		ModelAndView mav = new ModelAndView("tasks/search");
		mav.addObject("TASKS", foundTasks);

		return mav;
	}
	

	@RequestMapping(value = "/priorities/all")
	public ModelAndView viewAllPriorities() {
		List<Priority> priorities = daoPriorities.findAll();

		ModelAndView mav = new ModelAndView("dashboard/allpriorities");
		mav.addObject("PRIORITIES", priorities);

		return mav;
	}
	
	@RequestMapping(value = "/categories/edit/{categoryid}")
	public ModelAndView editTaskCategory(@PathVariable("categoryid") Integer categoryId) {
		Categories cat = daoCategories.read(categoryId);
		ModelAndView mav = new ModelAndView("tasks/editcategory", "command", cat);
		mav.addObject("categoryid", categoryId);
		return mav;
	}
	
	@RequestMapping(value = "/statuses/edit/{statusid}")
	public ModelAndView editTaskStatus(@PathVariable("statusid") Integer statusId) {
		Status stat = daoStatuses.read(statusId);
		ModelAndView mav = new ModelAndView("tasks/editstatus", "command", stat);
		return mav;
	}
	
	@RequestMapping(value = "/categories/edit", method=RequestMethod.POST)
	public ModelAndView saveTask(@ModelAttribute("category")Categories category){
		ModelAndView mav = new ModelAndView("redirect:/dashboard/dashboard.htm");
		daoCategories.update(category);
		return mav;
	}
	
	
	@RequestMapping(value = "/statuses/edit", method=RequestMethod.POST)
	public ModelAndView updateStatus(@ModelAttribute("status")Status status){
		ModelAndView mav = new ModelAndView("redirect:/dashboard/dashboard.htm");
		daoStatuses.update(status);
		return mav;
	}
	
	@RequestMapping(value = "/priorities/edit/{priorid}")
	public ModelAndView editPriority(@PathVariable("priorid") Integer priorityId) {
		Priority priority = daoPriorities.read(priorityId);
		ModelAndView mav = new ModelAndView("tasks/editpriority", "command", priority);
		return mav;
	}
	
	@RequestMapping(value = "/priorities/edit", method=RequestMethod.POST)
	public ModelAndView saveTask(@ModelAttribute("priority")Priority priority){
		ModelAndView mav = new ModelAndView("redirect:/dashboard/dashboard.htm");
		daoPriorities.update(priority);
		return mav;
	}

	@RequestMapping(value = "/viewtask/{taskid}", method = RequestMethod.GET)
	public ModelAndView viewTask(@PathVariable("taskid") Integer taskid, ModelMap model) {

		FileBucket fileModel = new FileBucket();
		fileModel.setTaskId(taskid);
		model.addAttribute("fileBucket", fileModel);
		Tasks task = dao.getTaskWithComments(taskid);

		Comments comment = new Comments();
		// comment.setTaskid(task);
		comment.setSpringTaskId(task.getId());

		ModelAndView mav = new ModelAndView("tasks/viewtask", "command" , comment);
		mav.addObject("TASK", task);
		return mav;
	}
	
	@RequestMapping(value = "/viewtask", method = RequestMethod.POST)
	public ModelAndView addCommentToTask(@ModelAttribute("comment")Comments comment){
		System.out.println("SAVING COMMENT: " + comment);
		
		Tasks task = dao.read(comment.getSpringTaskId());
		Integer taskId = task.getId();
		comment.setTaskid(task);
		Users user = usersService.getUserFromSecurity();
		System.out.println("ASSOCIATED USER: " + user);
		comment.setUser(user);
		daoComments.create(comment);
		ModelAndView mav = new ModelAndView("redirect:viewtask/"+taskId);
		return mav;
	}

}
