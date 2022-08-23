package com.example.lab3.dto;

import com.example.lab3.domain.Post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class PostCreateDto {
	
	private String title;
	private String content;
	private String author;
	
	@Builder
	private PostCreateDto(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	public Post toEntity() {
		// DTO 객체를 Entity 객체로 변환해서 리턴. 
		return Post.builder()
				.title(this.title)
				.content(this.content)
				.author(this.author)
				.build();
	}
	
}
