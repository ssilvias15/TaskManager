package ie.silvia.spring.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;



@EnableWebMvc 

@Configuration

@ComponentScan({ "ie.silvia.spring.controller" })

@Import({SecurityConfig.class})

public class SpringWebConfig extends WebMvcConfigurerAdapter {



	@Override

	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");

	}



	@Bean

	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setViewClass(JstlView.class);

		viewResolver.setPrefix("/WEB-INF/jsp/");

		viewResolver.setSuffix(".jsp");

		return viewResolver;

	}



	@Override

	public void addViewControllers(ViewControllerRegistry registry) {

//		registry.addViewController("/home").setViewName("home");
//
//		registry.addViewController("/").setViewName("home");
//
//		registry.addViewController("/hello").setViewName("hello");
//
//		registry.addViewController("/login").setViewName("login");

	}



}