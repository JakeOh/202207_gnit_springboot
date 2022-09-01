package com.example.lab3.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class PostUpdateDto {
	private String title;
	private String content;
	
	@Builder
	private PostUpdateDto(String title, String content) {
		this.title = title;
		this.content = content;
	}

}
