package ie.silvia.spring.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import ie.silvia.model.upload.UploadConstants;



@EnableWebMvc 

@Configuration

@ComponentScan({ "ie.silvia.spring.controller" })

@Import({SecurityConfig.class})

public class SpringWebConfig extends WebMvcConfigurerAdapter {



	@Override

	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/files/**").addResourceLocations("file:///"+UploadConstants.UPLOAD_PATH);


	}



	@Bean

	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setViewClass(JstlView.class);

		viewResolver.setPrefix("/WEB-INF/jsp/");

		viewResolver.setSuffix(".jsp");

		return viewResolver;

	}
	
	
	@Bean(name="dataSource")
	public DriverManagerDataSource dataSource(){
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

	    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");

	    driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/tasksproject");

	    driverManagerDataSource.setUsername("root");

	    driverManagerDataSource.setPassword("familiamea15");

	    return driverManagerDataSource;
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
		registry.addViewController("/login");
	}

	/** UPLOAD CONFIGURATION **/
	 @Bean(name = "multipartResolver")

	    public StandardServletMultipartResolver resolver() {

	        return new StandardServletMultipartResolver();

	    }


}