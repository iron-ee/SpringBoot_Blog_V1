package com.cos.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.blog.service.AuthService;
import com.cos.blog.web.auth.dto.AuthJoinReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller		// @Controller => 파일을 리턴하는 서버  , RestController => 데이터를 리턴하는 서버
public class AuthController {

	private final AuthService authService;
	
	// 주소 : 인증이 안 되었을땐 /user, /post, 인증이 되든 말든 무조건 올 수 있음 /loginForm
		@GetMapping("/loginForm")
		public String loginForm() {
			return "auth/loginForm";
		}
		
		@GetMapping("/joinForm")
		public String joinForm() {
			return "auth/joinForm";
		}
		
		@PostMapping("/join")
		public String join(AuthJoinReqDto authJoinReqDto) {
			authService.회원가입(authJoinReqDto.toEntity());
			return "redirect:/loginForm";
		}

}
