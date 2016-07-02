package ie.silvia.spring.config;



import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {



	@Override

	protected Class<?>[] getRootConfigClasses() {

		return new Class[] {  SpringRootConfig.class, SpringWebConfig.class, SecurityConfig.class};

	}



	@Override

	protected Class<?>[] getServletConfigClasses() {

		return new Class[] { SpringWebConfig.class, SecurityConfig.class };

	}



	@Override

	protected String[] getServletMappings() {

		return new String[] { "/" };

	}



}