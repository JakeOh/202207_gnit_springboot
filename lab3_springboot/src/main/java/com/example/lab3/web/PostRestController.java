package com.example.lab3.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lab3.dto.PostCreateDto;
import com.example.lab3.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/post")
// 클래스가 가지고 있는 모든 메서드들의 요청 주소는 "/api/post"로 시작.
public class PostRestController {
	
	// @RequiredArgsConstructor + final 필드 => 생성자에 의한 의존성 주입.
	private final PostService postService;

	@PostMapping
	public Long createPost(@RequestBody PostCreateDto dto) {
		// @RequestBody: Ajax 요청에 포함된 데이터(json 문자열)을 
		// 분석해서 자바 객체로 전달
		log.info("createPost(dto={})", dto);
		
		// Service 계층의 메서드를 사용해서 DB에 insert.
		return postService.create(dto);
	}
	
}
