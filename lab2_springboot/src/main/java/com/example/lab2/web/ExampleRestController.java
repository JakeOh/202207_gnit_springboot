package com.example.lab2.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lab2.dto.ExampleResponseDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController  // 스프링 컨텍스트에 RestController 컴포넌트로 관리됨.
// RestController 클래스의 메서드들이 리턴하는 값은 클라이언트로 직접 전달됨.
public class ExampleRestController {
	
	@GetMapping("/rest1")
	public String rest1() {
		log.info("rest1() 호출");
		
		// 리턴값은 뷰를 찾기 위한 이름이 아니라, 
		// 클라이언트로 직접 전달되는 값.
		return "안녕하세요, REST controller!";
	}
	
	@GetMapping("/rest2/{name}")
	public String rest2(@PathVariable(name = "name") String userName) {
		// PathVariable의 이름과 파라미터의 이름을 같게 만드는 경우에는
		// (name = "varName") 설정은 생략 가능.
		log.info("rest2(name={}) 호출", userName);
		
		return "Hello, " + userName + "!";
	}

	@GetMapping("/rest3")
	public ExampleResponseDto rest3(@RequestParam String id,
			@RequestParam String email) {
		log.info("rest3(id={}, email={}) 호출", id, email);
		
		ExampleResponseDto dto = ExampleResponseDto.builder()
				.id(id)
				.email(email)
				.build();
		
		return dto;
	}
	
	
}
