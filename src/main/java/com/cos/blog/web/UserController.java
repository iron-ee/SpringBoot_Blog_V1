package com.cos.blog.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.config.auth.PrincipalDetails;

@Controller		// @Controller => 파일을 리턴하는 서버  , RestController => 데이터를 리턴하는 서버
public class UserController {

	// 로그인, 로그아웃, 회원가입, 회원정보 변경 (AuthContoller)
	//
	
	@GetMapping("/user")
	public @ResponseBody String findAll(@AuthenticationPrincipal PrincipalDetails principalDetails) {	// @Controller + @ResponseBody => @RestController
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
//		System.out.println(principalDetails.getUser());
		System.out.println(principalDetails.getUsername());
		return "User";
	}

}
