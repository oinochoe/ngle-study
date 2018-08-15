package com.ym.blog.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ym.blog.aop.CategoryInterceptor;
import com.ym.blog.aop.UserSessionArgumentResolver;
import com.ym.blog.aop.UserSessionInterceptor;
import com.ym.blog.infrastructure.dao.CategoryDao;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private ConnectionRepository connectionRepository;

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new UserSessionInterceptor(connectionRepository));
		registry.addInterceptor(new CategoryInterceptor(categoryDao));
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new UserSessionArgumentResolver());
	}
}
