package br.jus.tjerj.skeleton.configuration.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.jus.tjerj.skeleton.configuration.exceptionhandlers.JwtExceptionHandler;
import br.jus.tjerj.skeleton.configuration.security.JwtAuthenticationFilter;
import br.jus.tjerj.skeleton.configuration.security.JwtAuthorizationFilter;
import br.jus.tjerj.skeleton.support.segweb.SegwebAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
//    private SegwebAuthenticationProvider authProvider;
	
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
		  http.csrf().disable().authorizeRequests().anyRequest().permitAll();
//	    http.csrf().disable().authorizeRequests()
//	        .antMatchers("/").permitAll()
//	        .antMatchers(HttpMethod.POST, "/login").permitAll()
//	        .anyRequest().authenticated()
//	        .and()
//	        .addFilterBefore(new JwtAuthenticationFilter("/login", authenticationManager()),
//	                UsernamePasswordAuthenticationFilter.class)        
//	        .addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
//	    	.addFilterBefore(new JwtExceptionHandler(), JwtAuthenticationFilter.class);
	  }
	
//	  @Override
//	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		  auth.authenticationProvider(authProvider);
//	  }
}