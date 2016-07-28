package ie.silvia.spring.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ie.silvia.dao.impl.DAOComments;
import ie.silvia.dao.impl.DAOTasks;
import ie.silvia.model.Comments;
import ie.silvia.model.Tasks;
import ie.silvia.model.upload.FileBucket;

@Controller
@RequestMapping("/tasks")
public class TasksController {

	private DAOTasks dao = new DAOTasks();
	private DAOComments daoComments = new DAOComments();
	private FormOptionsService fos = new FormOptionsService();

	@RequestMapping(value = "/edit/{taskid}")
	public ModelAndView editTask(@PathVariable("taskid") Integer taskid) {
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

	@RequestMapping(value = "/viewtask/{taskid}", method = RequestMethod.GET)
	public ModelAndView viewTask(@PathVariable("taskid") Integer taskid, ModelMap model) {

		FileBucket fileModel = new FileBucket();
		fileModel.setTaskId(taskid);

		model.addAttribute("fileBucket", fileModel);
		Tasks task = dao.read(taskid);

		Comments comment = new Comments();
		comment.setTaskid(task);

		ModelAndView mav = new ModelAndView("tasks/viewtask", "command" , comment);
		mav.addObject("TASK", task);
		return mav;
	}
	
	@RequestMapping(value = "/viewtask", method = RequestMethod.POST)
	public ModelAndView addCommentToTask(@ModelAttribute("comment")Comments comment){
		System.out.println("SAVING COMMENT: " + comment);
		System.out.println("COMMENT ASSOCIATED TO TASK: " + comment.getTaskid());
		Integer taskId = comment.getTaskid().getId(); // never null
		daoC
		ModelAndView mav = new ModelAndView("redirect:/viewtask/"+taskId);
		return mav;
	}

}
