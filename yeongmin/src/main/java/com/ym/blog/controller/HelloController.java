package com.ym.blog.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class HelloController {

	@RequestMapping("/")
	public String hello(Model model) {
		model.addAttribute("name", "SpringBlog from Yeongmin");
		return "hello";
	}
	
	/*@RequestMapping("/")
	public String list(Model model){
		//model.model.addAttribute("name", "김영민입니다.");
		return "post/list";
	}*/
}