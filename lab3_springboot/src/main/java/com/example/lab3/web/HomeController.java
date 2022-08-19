package com.example.lab3.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		log.info("home() 호출");
		
		// TODO: DB에서 posts 테이블의 모든 데이터를 검색해서 뷰에게 전달
		
		return "index";
	}

}
