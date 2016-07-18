package ie.silvia.spring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ie.silvia.dao.impl.DAOCategories;
import ie.silvia.dao.impl.DAOUsers;
import ie.silvia.model.Categories;
import ie.silvia.model.Users;

@Controller
@RequestMapping(value = "/dashboard")
public class DashboardAdminController {

	private DAOUsers dao;
	private DAOCategories daoCategories;

	public DashboardAdminController() {
		dao = new DAOUsers();
		daoCategories = new DAOCategories();
	}

	@RequestMapping(value = "/adduser.htm", method = RequestMethod.GET)
	public ModelAndView viewAddUser() {
		ModelAndView mav = new ModelAndView("dashboard/adduser", "command", new Users());

		return mav;
	}

	@RequestMapping(value = "/adduser.htm", method = RequestMethod.POST)
	public ModelAndView saveAddUser(@ModelAttribute("user") Users user) {
		ModelAndView mav = new ModelAndView("redirect:/dashboard/dashboard.htm");
		System.out.println("Saving user: " + user);
		dao.create(user);
		return mav;
	}

	@RequestMapping(value = "/allusers.htm", method = RequestMethod.GET)
	public ModelAndView viewAllUsers() {
		ModelAndView mav = new ModelAndView("dashboard/allusers");
		List<Users> allUsers = dao.findAll();
		mav.addObject("USERS", allUsers);
		return mav;

	}

	@RequestMapping(value = "/deleteuser.htm", method = RequestMethod.GET)
	public ModelAndView deleteUser(@RequestParam("userid") Integer id) {
		ModelAndView mav = new ModelAndView("redirect:/dashboard/dashboard.htm?userdeleted=ok");
		Users user = dao.read(id);
		dao.delete(user);
		return mav;
	}

	@RequestMapping(value = "/deletecategory.htm", method = RequestMethod.GET)
	public ModelAndView deleteCategories(@RequestParam("categoryid") Integer id) {
		ModelAndView mav = new ModelAndView("redirect:/dashboard/dashboard.htm?categorydeleted=ok");
		Categories cat = daoCategories.read(id);
		daoCategories.delete(cat);
		return mav;
	}

	
	// EDIT USER
	@RequestMapping(value = "/edituser.htm", method = RequestMethod.GET)
	public ModelAndView editUser(@RequestParam("userid") Integer id) {

		// TODO: find specific user
		Users specificUser = dao.read(id);
		ModelAndView mav = new ModelAndView("dashboard/edituser", "command", specificUser);
		mav.addObject("USER_ID", id);
		return mav;
	}

	@RequestMapping(value = "/edituser.htm", method = RequestMethod.POST)
	public ModelAndView editUserUpdate(@ModelAttribute("user") Users user) {

		System.out.println("UPDATING USER: " + user);
		dao.update(user);
		ModelAndView mav = new ModelAndView("redirect:/dashboard/dashboard.htm");
		return mav;
	}

	// EDIT CATEGORY
	@RequestMapping(value = "/editcategory.htm", method = RequestMethod.GET)
	public ModelAndView editCategory(@RequestParam("categoryid") Integer id) {

		Categories cat = daoCategories.read(id);
		ModelAndView mav = new ModelAndView("dashboard/editcategory", "command", cat);
		return mav;
	}

	@RequestMapping(value = "/editcategory.htm", method = RequestMethod.POST)
	public ModelAndView editCategoryUpdate(@ModelAttribute("category") Categories category) {

		System.out.println("UPDATING CATEGORY: " + category);
		daoCategories.update(category);
		ModelAndView mav = new ModelAndView("redirect:/dashboard/dashboard.htm");
		return mav;
	}

	/** Categories - needed when adding tasks **/
	@RequestMapping(value = "/addcategory.htm", method = RequestMethod.GET)
	public ModelAndView addCategory() {
		ModelAndView mav = new ModelAndView("dashboard/addcategory", "command", new Categories());

		return mav;
	}

	@RequestMapping(value = "/addcategory.htm", method = RequestMethod.POST)
	public ModelAndView addCategorySave(@ModelAttribute("category") Categories category) {
		ModelAndView mav = new ModelAndView("redirect:/dashboard/dashboard.htm");
		System.out.println("Saving category: " + category);
		daoCategories.create(category);
		return mav;
	}

	@RequestMapping(value = "/dashboard.htm", method = RequestMethod.GET)
	public ModelAndView viewDashboard() {
		List<Categories> categories = daoCategories.findAll();
		List<Users> users = dao.findAll();
		ModelAndView mav = new ModelAndView("dashboard");
		mav.addObject("USERS", users);
		mav.addObject("CATEGORIES", categories);
		return mav;
	}

}
