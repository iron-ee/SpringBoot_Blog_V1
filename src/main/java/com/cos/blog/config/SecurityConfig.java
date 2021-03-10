package com.cos.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration	// IoC 등록
public class SecurityConfig extends WebSecurityConfigurerAdapter{	// 어뎁터를 쓴다는건 무언가를 걸러준다는 것

	// IoC 등록만 하면 AuthenticationManager가 BCrypt로 자동 검증해준다.
	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/user","/post").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")	// USER, ADMIN 모두 접근 가능	* ROLE 검증시에 ROLE_ 이라는 이름으로 넣어주어야만 인식가능 (강제성) 
			.antMatchers("/admin").access("hasRole('ROLE_ADMIN')")	// ADMIN 만 접근 가능											  그래서 UserDetails 에서 return 해줄 때 앞에 ROLE_ 을 넣어주면 된다 !!
			.anyRequest().permitAll()
			.and()
			.formLogin()	// x-www-form-urlencoded 타입으로 던져주어야한다. json으로 던지면 못 받는다!!
			.loginPage("/loginForm")
			.loginProcessingUrl("/login");	
	}
}
