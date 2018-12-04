/* Nama File : SecurityConfig.java
 * NIM		 : 11S16054
 * Kelas	 : 13TI02 */

package com.sikjb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.sikjb.web.LoggingAccessDeniedHandler;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
@Autowired
 private LoggingAccessDeniedHandler accessDeniedHandler;
 @Override
 protected void configure(HttpSecurity http) throws Exception
 {
	 http.csrf().disable()
	 .authorizeRequests()
	 .antMatchers(
	"/",
	 "/js/**",
	"/css/**").permitAll()
	 .antMatchers("/user/**").hasRole("USER")
	 .anyRequest().authenticated()
	 .and()
	 .formLogin()
	 .loginPage("/login")
	.permitAll()
	 .and()
	 .logout()
	 .invalidateHttpSession(true)
	.clearAuthentication(true)
	.logoutRequestMatcher(new
	AntPathRequestMatcher("/logout"))
	.logoutSuccessUrl("/login?logout")
	 .permitAll()
	 .and()
	 .exceptionHandling()
	 .accessDeniedHandler(accessDeniedHandler);
 }
 
 @Override
 protected void configure(AuthenticationManagerBuilder auth) throws
Exception
 {
	 auth.inMemoryAuthentication().withUser("user").password("{noop}user123"
			 ).roles("USER");
			 auth.inMemoryAuthentication().withUser("manager").password("{noop}manager123").roles("MANAGER");
			  /*auth.inMemoryAuthentication()
			  .withUser("user").password("password").roles("USER")
			  .and()
			  .withUser("manager").password("password").roles("MANAGER");*/
			  }
			 }
 