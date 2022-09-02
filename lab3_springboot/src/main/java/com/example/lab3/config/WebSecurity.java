package com.example.lab3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// Spring Security 관련 설정 - WebSecurityConfigurerAdapter 상속
// WebSecurityConfigurerAdapter 클래스의 confiure 메서드를 재정의.
@Configuration // Spring Boot가 사용하는 환경 설정 객체(bean)
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Bean // 스프링 프레임워크에서 객체(bean)를 관리.
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// 사용자 인증 - 로그인 가능한 사용자 인증 설정.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// in-memory user store를 이용.
		auth.inMemoryAuthentication()
			.withUser("user1")
			.password(passwordEncoder().encode("pass1"))
			.roles("USER")
			.and()
			.withUser("user2")
			.password(passwordEncoder().encode("pass2"))
			.roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.headers().frameOptions().disable()
		//
		.and()
			.authorizeHttpRequests() // 인증 필요한 요청, 인증 필요없는 요청을 설정.
			.antMatchers("/post/create", "/post/read/**", 
					"/post/modify/**", "/api/post/**")
			.hasRole("USER")
			.antMatchers("/", "/**")
			.permitAll()
		.and()
			.httpBasic()
		;
	}

}
