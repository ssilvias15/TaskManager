package ie.silvia.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/test")
	public ModelAndView testCSS(){
		ModelAndView mav = new ModelAndView("test/blank");
		return mav;
	}
}
