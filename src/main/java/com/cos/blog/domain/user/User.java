package com.cos.blog.domain.user;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	@Id	// Primary Key
	@GeneratedValue
	private Integer id;	// 시퀀스, auto_increment
	
	@Column(nullable = false, length = 100, unique = true)
	private String username;
	
	@Column(nullable = false, length = 100)	// 123456 => 해쉬 (비밀번호 암호화) 때문에 <= 얘가 64자 이상인가 들어옴
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;	// myEmail, my_email
	
	@Enumerated(EnumType.STRING)	// 원래는 EnumType 이 Integer 타입으로 들어오는걸 String 타입으로 받고 싶을 때 !
	private RoleType role; //ADMIN, USER
	
	@CreationTimestamp
	private Timestamp createDate;
}
