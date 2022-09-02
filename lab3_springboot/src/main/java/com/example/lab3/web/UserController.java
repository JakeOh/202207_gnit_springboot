package com.example.lab3.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {
	
	@GetMapping("/user/signup")
	public String signUp() {
		log.info("signUp() 호출");
		
		return "user/signup";
	}

}
