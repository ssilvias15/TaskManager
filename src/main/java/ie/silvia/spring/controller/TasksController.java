package ie.silvia.spring.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ie.silvia.dao.impl.DAOTasks;
import ie.silvia.model.Categories;
import ie.silvia.model.Priority;
import ie.silvia.model.Status;
import ie.silvia.model.Tasks;
import ie.silvia.model.Users;
import ie.silvia.model.upload.FileBucket;

@Controller
@RequestMapping("/tasks")
public class TasksController {

	private DAOTasks dao = new DAOTasks();
	private FormOptionsService fos = new FormOptionsService();

	@RequestMapping(value="/edit/{taskid}")
	public ModelAndView editTask(@PathVariable("taskid") Integer taskid){
		Tasks currentTask = dao.read(taskid);
		ModelAndView mav = new ModelAndView("tasks/edit", "command", currentTask);
		
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
		
		mav.addObject("taskid", taskid);
		
		return mav;
	}
	
	
	@RequestMapping(value="/viewtask/{taskid}", method=RequestMethod.GET)
	public ModelAndView viewTask(@PathVariable("taskid") Integer taskid, ModelMap model){
		
		 FileBucket fileModel = new FileBucket();
		 fileModel.setTaskId(taskid);
	        

		
		ModelAndView mav = new ModelAndView("tasks/viewtask");
		
		model.addAttribute("fileBucket", fileModel);
		Tasks task = dao.read(taskid);
		mav.addObject("TASK", task);
		return mav;
	}
	
}
