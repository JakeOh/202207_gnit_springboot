package com.example.lab3.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lab3.dto.UserRegisterDto;
import com.example.lab3.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {
	
	private final UserService userService;
	
	@GetMapping("/user/signup")
	public String signUp() {
		log.info("signUp() GET 호출");
		
		return "user/signup";
	}
	
	@PostMapping("/user/signup")
	public String signUp(UserRegisterDto dto) {
		// dispatcherServlet이 form에서 제출된 데이터를 DTO로 변환.
		log.info("signUp(dto={}) POST 호출", dto);
		
		// TODO: 폼의 비밀번호를 암호화.
		
		// UserService 객체를 사용해서 DB에 새로운 User를 생성.
		Long id = userService.registerUser(dto);
		log.info("회원가입 PK = {}", id);
		
		// 회원 가입 후에 메인 페이지로 새로운 요청을 생성(redirect).
		return "redirect:/";
	}

}
