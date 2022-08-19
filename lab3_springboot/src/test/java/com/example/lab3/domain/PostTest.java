package com.example.lab3.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j // 로그 사용
@SpringBootTest // 스프링 부트 애플리케이션 단위 테스트(Unit Test)
public class PostTest {
	
	@Test // JUnit 테스트 메서드
	public void testPostCreation() {
		String title = "테스트 제목";
		String content = "Test Content";
		String author = "guest";
		
		Post post = Post.builder()
				.title(title)
				.content(content)
				.author(author)
				.build();
		log.info(post.toString());
		
		// post 객체의 title 값이 지역변수 title의 값과 같으면 테스트 성공.
		assertEquals(title, post.getTitle());
		assertEquals(content, post.getContent());
		assertEquals(author, post.getAuthor());
	}

}
