package ie.silvia.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ie.silvia.dao.impl.DAOTasks;
import ie.silvia.model.Tasks;
import ie.silvia.model.upload.FileBucket;

@Controller
@RequestMapping("/tasks")
public class TasksController {

	private DAOTasks dao = new DAOTasks();
	
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
