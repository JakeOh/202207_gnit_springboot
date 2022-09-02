package com.example.lab3.dto;

import com.example.lab3.domain.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserRegisterDto {
	private String username;
	private String password;
	private String email;
	
	@Builder
	public UserRegisterDto(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	// DTO를 Entity로 변환해서 리턴하는 메서드.
	public User toEntity() {
		return User.builder()
				.username(username)
				.password(password)
				.email(email)
				.build();
	}

}
