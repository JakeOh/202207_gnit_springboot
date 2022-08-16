package com.example.lab2.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lab2.dto.ExampleRequestDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j  // (콘솔 창 또는 파일에) 로그를 사용하기 위해서
@Controller  // 클래스를 스프링 부트 앱에 컨트롤러 객체로 등록.
public class ExampleController {

	// 요청 주소 "/ex1", 요청 방식 "GET"을 처리하는 컨트롤러 메서드
	@GetMapping("/ex1")
	public String ex1() {
		log.info("ex1() 호출...");
		
		// 템플릿 엔진(thymeleaf, mustache, ...)을 사용하는 경우에,
		// 컨트롤러 메서드의 문자열 리턴값은
		// src/main/resources/templates 폴더 아래의 (하위 폴더 포함) 파일이름을 의미함.
		return "/example/ex1";
	}
	
	@PostMapping("/ex2")
	public String ex2(@RequestParam String userName,
			@RequestParam(name = "userAge") Integer age,
			Model model) {
		// @RequestParam: 요청 파라미터의 값을 분석해서 메서드 파라미터(매개변수)에 전달.
		// 보통 메서드 파라미터 이름은 요청 파라미터 이름과 같게 만듦.
		// 메서드 파라미터의 이름과 요청 파라미터의 이름이 다른 경우에는 
		// @RequestParam(name = "requestParam") 형식으로 설정.
		
		log.info("ex2(userName={}, userAge={})", 
				userName, age);
		
		// Model: 컨트롤러에서 뷰(UI)에 데이터를 전달할 때 사용.
		model.addAttribute("userName", userName);
		model.addAttribute("userAge", age);
		
		return "/example/ex2";
	}
	
	@GetMapping("/ex3")
	public String ex3() {
		log.info("ex3() 호출");
		return "/example/ex3";
	}
	
	@PostMapping("/ex4")
	public String ex4(ExampleRequestDto dto, Model model) {
		// DispatcherServlet이 컨트롤러 메서드를 호출할 때,
		// 요청 파라미터들을 분석해서 ExampleRequestDto 객체를 생성하고
		// argument로 전달해줌.
		log.info("ex4(dto={})", dto);
		
		model.addAttribute("dto", dto);
		
		return "/example/ex4";
	}
	
	@GetMapping("/ex5")
	public String ex5() {
		return "/example/ex5";
	}
	
}
