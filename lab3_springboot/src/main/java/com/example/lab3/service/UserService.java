package com.example.lab3.service;

import org.springframework.stereotype.Service;

import com.example.lab3.domain.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final 멤버변수를 명시적으로 초기화하는 생성자를 자동으로 만듦.
@Service
public class UserService {
	
	private final UserRepository userRepository;

}
