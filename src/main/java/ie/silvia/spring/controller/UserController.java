package ie.silvia.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ie.silvia.dao.impl.DAOUsers;
import ie.silvia.model.Users;
import ie.silvia.service.UsersService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	private DAOUsers daoUsers = new DAOUsers();
	private UsersService userService = new UsersService(daoUsers);

	@RequestMapping("/profile")
	public ModelAndView viewProfile(){
		
		Users currentUser = userService.getUserFromSecurity();
		ModelAndView mav = new ModelAndView("users/userprofile", "command", currentUser);
		mav.addObject("CURRENT_USER", currentUser);
		return mav;
	}
	

	@RequestMapping(value = "/profile", method=RequestMethod.POST)
	public ModelAndView viewProfile(@ModelAttribute("user")Users user){
		ModelAndView mav = new ModelAndView("redirect:/users/profile");
		System.out.println("EDITING DATA FOR USER: ");
		System.out.println(user);
		return mav;
	}
	
}
