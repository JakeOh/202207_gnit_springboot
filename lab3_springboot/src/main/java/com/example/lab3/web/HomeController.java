package com.example.lab3.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lab3.domain.Post;
import com.example.lab3.dto.PostResponseDto;
import com.example.lab3.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {
	
	private final PostService postService;
	
	@GetMapping("/")
	public String home(Model model) {
		log.info("home() 호출");
		
		// 서비스 객체를 이용해서 posts 테이블의 모든 데이터를 검색해서 뷰에게 전달
		List<PostResponseDto> posts = postService.findAll();
		log.info("# of posts = {}", posts.size());
		model.addAttribute("posts", posts);
		
		return "index";
	}
	
	@GetMapping("/post/create")
	public String newPostPage() {
		log.info("newPostPage() 호출");
		return "/post/create";
	}
	
	@GetMapping("/post/read/{id}")
	public String readPostPage(@PathVariable Long id, Model model) {
		log.info("readPostPage(id={}) 호출", id);
		
		// Service 객체를 이용해서 DB에 저장된 포스트를 읽어옴.
		Post post = postService.read(id);
		log.info("read post = {}", post);
		// 읽어 온 데이터를 뷰(HTML)에 전달
		model.addAttribute("post", post);
		
		return "/post/read";
	}

	@GetMapping("/post/modify/{id}")
	public String modifyPostPage(@PathVariable Long id, Model model) {
		log.info("modifyPostPage(id={}) 호출", id);
		
		Post post = postService.read(id);
		model.addAttribute("post", post);
		
		return "/post/modify";
	}
	
	@GetMapping("/post/search")
	public String search(@RequestParam String type,
			@RequestParam String keyword, 
			Model model) {
		log.info("search(type={}, keyword={})", type, keyword);
		
		// postService 메서드를 사용해서 검색 결과를 가져옴.
		List<PostResponseDto> searchResult = 
				postService.search(type, keyword);
		
		// 검색 결과를 model에 add를 해서 뷰(HTML template)로 전달.
		model.addAttribute("posts", searchResult);
		
		return "index";
	}
	
}
