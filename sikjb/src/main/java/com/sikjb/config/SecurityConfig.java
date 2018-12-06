/* Nama File : SecurityConfig.java
 * NIM		 : 11S16054
 * Kelas	 : 13TI02 */

package com.sikjb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.sikjb.web.LoggingAccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
 	private LoggingAccessDeniedHandler accessDeniedHandler;
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

 	@Override
 	protected void configure(HttpSecurity http) throws Exception
 	{
	 			http.csrf().disable()
	 			.authorizeRequests()
				.antMatchers("/", "/js/**", "/css/**").permitAll()
	 			.antMatchers("/admin/**")
				.hasRole("ADMIN")
	 			.anyRequest().authenticated()
	 			.and()
				.formLogin()
	 			.loginPage("/login").successHandler(new AuthenticationSuccessHandler() {
					@Override
					public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
						redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/home");
					}
				})
				.permitAll()
	 			.and()
	 			.logout()
	 			.invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout")
	 			.permitAll()
	 			.and()
	 			.exceptionHandling()
	 			.accessDeniedHandler(accessDeniedHandler);
 }
 
 	@Override
 	protected void configure(AuthenticationManagerBuilder auth) throws Exception
 	{
	 	auth.inMemoryAuthentication().withUser("admin").password("{noop}admin123").roles("ADMIN");
 	}
}