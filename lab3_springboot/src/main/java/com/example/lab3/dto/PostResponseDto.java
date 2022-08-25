package com.example.lab3.dto;

import java.time.LocalDateTime;

import com.example.lab3.domain.Post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class PostResponseDto {
	private Long id;
	private String title;
	private String author;
	private LocalDateTime modifiedDate;
	
	// Post 엔터티 객체로 DTO 객체를 생성하기 위한 생성자.
	public PostResponseDto(Post post) {
		this.id = post.getId();
		this.title = post.getTitle();
		this.author = post.getAuthor();
		this.modifiedDate = post.getModifiedDate();
	}

}
