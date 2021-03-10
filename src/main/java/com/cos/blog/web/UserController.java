package com.cos.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller		// @Controller => 파일을 리턴하는 서버  , RestController => 데이터를 리턴하는 서버
public class UserController {

	
	
	@GetMapping("/user")
	public @ResponseBody String hello() {	// @Controller + @ResponseBody => @RestController
		return "User";
	}
	
	@GetMapping("/")
	public String home() {
		return "index";	//View Resolver 발동
	}
}
