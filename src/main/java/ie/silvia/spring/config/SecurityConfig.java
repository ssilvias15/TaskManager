package ie.silvia.spring.config;

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

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth

            .inMemoryAuthentication()

                .withUser("user").password("password").roles("USER").and().

                withUser("jim").password("1234").roles("USER", "ADMIN");

    }
    
    @Override

	protected void configure(HttpSecurity http) throws Exception {



    	//
    	
    	  

//	  http.authorizeRequests().anyRequest().access("hasRole('USER')");

	  http

		.authorizeRequests()

			.anyRequest().authenticated()

			.and()

		.formLogin().and().logout(); //.and().logout().logoutUrl("logout").logoutSuccessUrl("login")



      

        }
    

}