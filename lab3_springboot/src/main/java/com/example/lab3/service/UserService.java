package com.example.lab3.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.lab3.domain.User;
import com.example.lab3.domain.UserRepository;
import com.example.lab3.dto.UserRegisterDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final 멤버변수를 명시적으로 초기화하는 생성자를 자동으로 만듦.
@Service
public class UserService implements UserDetailsService {
	
	private final UserRepository userRepository;

	public Long registerUser(UserRegisterDto dto) {
		log.info("registerUser(dto={}) 호출", dto);
		
		// User 엔터티가 리포지터리에 저장되면 PK를 리턴.
		User user = dto.toEntity();
		userRepository.save(user);
		
		return user.getId();
	}

	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		// DB에 username을 갖는 엔터티가 있으면 그 엔터티 객체를 리턴.
		// 엔터티가 없으면 null을 리턴하지 말고 UsernameNotFoundException을 발생시켜야 함.
		// User 클래스가 UserDetails 인터페이스를 구현하고 있으면
		// User가 UserDetails의 하위 타입이므로 리턴할 수 있음.
		User entity = userRepository.findByUsername(username);
		if (entity != null) {
			return entity;
		}
		
		throw new UsernameNotFoundException(username + " Not Found!");
	}

}
