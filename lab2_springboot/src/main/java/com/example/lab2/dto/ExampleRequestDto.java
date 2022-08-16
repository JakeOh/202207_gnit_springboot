package com.example.lab2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor  // 기본 생성자를 자동으로 생성.
@Getter  // getter 메서드 자동 생성.
@Setter  // setter 메서드 자동 생성.
@ToString  // toString() 메서드 자동 생성.
public class ExampleRequestDto {
	
	// 필드들의 이름을 요청 파라미터 이름과 동일하게.
	private String userName;
	private String userPwd;
	private String userAge;
	
}
