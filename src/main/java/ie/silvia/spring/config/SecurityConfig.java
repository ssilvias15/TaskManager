package ie.silvia.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration

@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired

	DataSource dataSource;

	

	@Autowired

	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

		

	  auth.jdbcAuthentication().dataSource(dataSource)

		.usersByUsernameQuery(

			"select username,password, enabled from users where username=?")

		.authoritiesByUsernameQuery(

			"select username, role from user_roles where username=?");

	}	
	
	
//    @Autowired
//
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth
//
//            .inMemoryAuthentication()
//
//                .withUser("user").password("password").roles("USER").and().
//
//                withUser("jim").password("1234").roles("USER", "ADMIN");
//
//    }
    
    @Override

	protected void configure(HttpSecurity http) throws Exception {

    	
    	http.authorizeRequests().antMatchers("/resources/**").permitAll();
    	//
    	
    	http.csrf().disable();


//	  http.authorizeRequests().anyRequest().access("hasRole('USER')");

	  http

		.authorizeRequests()

			.anyRequest().authenticated()

			.and()

		.formLogin().and().logout(); //.and().logout().logoutUrl("logout").logoutSuccessUrl("login")



      

        }
    

}