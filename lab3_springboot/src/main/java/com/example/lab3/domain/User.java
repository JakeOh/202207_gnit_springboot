package com.example.lab3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
@Entity(name = "USERS")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // PK
	
	@Column(nullable = false, unique = true)
	private String username; // 사용자 아이디
	
	@Column(nullable = false)
	private String password; // 비밀번호
	
	@Column(nullable = false)
	private String email;

	@Builder
	private User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	// TODO: spring security 구현
}
