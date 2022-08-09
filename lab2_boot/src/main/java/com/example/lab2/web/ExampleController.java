package com.example.lab2.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

// MVC(Model-View-Controller)
// Model: 데이터 클래스 객체
// View: UI(user interface). 템플릿. jsp, html, thymeleaf, mustache, ...
// Controller: 요청(request)를 처리하는 클래스 객체.
// @Controller: 스프링 부트 앱에 콘트롤러 객체로 등록(HandlerMapping이 찾을 수 있도록).

@Slf4j  // (콘솔 창에) 로그를 사용하기 위해서.
@Controller
public class ExampleController {
	
	// 요청주소 /ex1, 요청방식 GET인 요청을 처리하는 콘트롤러 메서드
	@GetMapping("/ex1")
	public String ex1() {
		log.info("ex1 호출");
		
		// 템플릿 엔진(thymeleaf, mustache)을 사용하는 경우,
		// 콘트롤러 메서드의 문자열 리턴값은 
		// src/main/resources/templates 폴더 아래의 파일 이름을 의미함.
		return "ex1";
	}
	
	@GetMapping("/ex2")
	public String ex2(@RequestParam String userName, Model model) {
		log.info("ex2(userName={})", userName);
		
		return "ex1";
	}

}
