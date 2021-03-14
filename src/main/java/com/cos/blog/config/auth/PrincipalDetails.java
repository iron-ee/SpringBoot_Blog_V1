package com.cos.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.cos.blog.domain.user.User;

import lombok.Data;

@Data	// principal (접근 주체) = 세션처럼 사용 =  Spring Security Context 에 보관 됨.
public class PrincipalDetails implements UserDetails, OAuth2User{	// UserDetails 상속받는 객체를 만든다.

	private User user;
	private Map<String, Object> attributes;		// OAuth 제공자로 부터 받은 회원 정보
	// 왜 Map으로 받냐? Object로 받으면 구글이면 구글, ㅏ카오면 카카오, 따로따로 Object를 다 만들어줘야 되는데
	// 이렇게 받으면 모든 제공자로부터 키 값으로 Object를 받을 수 있다.
	
	private boolean oauth = false;
	
	public PrincipalDetails(User user) {
		this.user = user;
	}
	
	public PrincipalDetails(User user, Map<String, Object> attributes) {
		this.user = user;
		this.attributes = attributes;
		this.oauth = true;
	}

	
	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	@Override
	public String getName() {
		return "몰라";
	}
	
	@Override
	public String getPassword() {	// 계정의 비밀번호를 리턴한다.
		return user.getPassword();
	}

	@Override
	public String getUsername() {	// 계정의 이름을 리턴한다.
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {	// 계정이 만료되지 않았는지 리턴한다. (true = 만료안 됨)
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {	// 계정이 잠겨있지 않았는지 리턴한다. (true = 잠기지 않음)
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {	// 비밀번호가 만료되지 않았는지 리턴한다.	(true = 만료안 됨)
		return true;
	}

	@Override
	public boolean isEnabled() {	// 계정이 활성화(사용가능)인지 리턴한다. (true = 활성화)
		return true;
	}

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("ROLE 검증 하는 중");
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(()->"ROLE_"+user.getRole().toString());
		return collectors;
	}

}

