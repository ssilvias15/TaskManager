package ie.silvia.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {

	public HelloController(){
		System.out.println("CREATING CONTROLLER");
	}
	
	@RequestMapping(value="/hello.htm", method=RequestMethod.GET)
	public ModelAndView helloMethod(){
		System.out.println("GREETINGS");
		return new ModelAndView("hello");
	}

	
	@RequestMapping(value="/somepizza.htm", method=RequestMethod.GET)
	public ModelAndView pizzaMethod(){
		System.out.println("GREETINGS");
		return new ModelAndView("pizza");  // WEB-INF/jsp/pizza.jsp
	}
}

