package com.ym.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.formLogin()
				.loginPage("/user/login")
			.and()
				.logout()
					.logoutUrl("/user/logout")
					.deleteCookies("JSESSIONID")
					.logoutSuccessUrl("/post/list")
			.and()
				.authorizeRequests()
					.antMatchers("/**/write*", "/**/edit*", "/**/delete*").authenticated()
					.antMatchers("/**").permitAll();
	}
	
	

/*	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/console/**");
	}
	h2 console 예외 처리 하는 부분인데 mysql 썼으므로 제외.
	*/
}
