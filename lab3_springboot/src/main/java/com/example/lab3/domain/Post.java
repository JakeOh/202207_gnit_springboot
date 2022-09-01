package com.example.lab3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.lab3.dto.PostUpdateDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
@Entity(name = "POSTS") 
// 엔터티 클래스 이름과 데이터베이스 테이블 이름이 다른 경우에는 name 속성을 설정.
public class Post extends BaseTimeEntity {

	@Id //Primary key(고유키)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;  // 포스트 번호
	
	@Column(length = 1000, nullable = false)
	private String title; // 포스트의 제목
	
	@Column(length = 4000, nullable = false)
	private String content; // 포스트의 본문(내용)
	
	private String author; // 포스트의 작성자 아이디

	@Builder
	public Post(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	// 엔터티(의 제목, 내용)를 업데이트하기 위한 메서드.
	public Post update(PostUpdateDto dto) {
		this.title = dto.getTitle();
		this.content = dto.getContent();
		
		return this;
	}
	
}
