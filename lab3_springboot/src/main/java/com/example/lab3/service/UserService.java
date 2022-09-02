package com.example.lab3.service;

import org.springframework.stereotype.Service;

import com.example.lab3.domain.User;
import com.example.lab3.domain.UserRepository;
import com.example.lab3.dto.UserRegisterDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final 멤버변수를 명시적으로 초기화하는 생성자를 자동으로 만듦.
@Service
public class UserService {
	
	private final UserRepository userRepository;

	public Long registerUser(UserRegisterDto dto) {
		log.info("registerUser(dto={}) 호출", dto);
		
		// User 엔터티가 리포지터리에 저장되면 PK를 리턴.
		User user = dto.toEntity();
		userRepository.save(user);
		
		return user.getId();
	}

}
