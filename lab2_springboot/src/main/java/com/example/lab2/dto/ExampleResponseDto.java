package com.example.lab2.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// DTO(Data Transfer Object): 클래스와 클래스 간에 데이터를 전달하기 위한 용도의 클래스.
// 메서드의 argument, 리턴 타입으로 사용하기 위한 클래스.

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ExampleResponseDto {
	private String id;
	private String email;
	
	@Builder
	public ExampleResponseDto(String id, String email) {
		this.id = id;
		this.email = email;
	}
	
}
