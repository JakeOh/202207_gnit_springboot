package com.example.lab3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.lab3.service.UserService;

import lombok.RequiredArgsConstructor;

// Spring Security 관련 설정 - WebSecurityConfigurerAdapter 상속
// WebSecurityConfigurerAdapter 클래스의 confiure 메서드를 재정의.
@RequiredArgsConstructor
@Configuration // Spring Boot가 사용하는 환경 설정 객체(bean)
@EnableWebSecurity // DB에 저장된 사용자 정보들을 사용한 인증, 권한 부여.
public class WebSecurity extends WebSecurityConfigurerAdapter {

	private final UserService userService; // 사용자 인증 설정에서 사용됨.
	
	@Bean // 스프링 프레임워크에서 객체(bean)를 관리.
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// 사용자 인증 - 로그인 가능한 사용자 인증 설정.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// in-memory user store를 이용.
//		auth.inMemoryAuthentication()
//			.withUser("user1")
//			.password(passwordEncoder().encode("pass1"))
//			.roles("USER")
//			.and()
//			.withUser("user2")
//			.password(passwordEncoder().encode("pass2"))
//			.roles("USER");
		
		// DB에 저장된 사용자 정보를 사용한 인증 설정
		auth.userDetailsService(userService)
			.passwordEncoder(passwordEncoder());
	}
	
	// HTTP 보안 설정
	// - 인증을 통해서 접근 가능한 페이지 설정
	// - 인증 없이 접근 가능한 페이지 설정
	// - 로그인 설정: 로그인 페이지(브라우저 기본값, 스프링 기본값, custom), Social login, ...
	// - 로그아웃 설정: 로그아웃 성공 후 이동(redirect) 페이지, ...
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.headers().frameOptions().disable()
		// 여기까지의 설정은 h2-console을 브라우저에서 사용하기 위해서.
		// Ajax를 사용하기 위해서.
		.and()
			.authorizeHttpRequests() // 인증 필요한 요청, 인증 필요 없는 요청을 설정.
			.antMatchers("/post/create", "/post/read/**", 
					"/post/modify/**", "/api/post/**")
			.hasRole("USER")
			// -> ROLE_USER 권한을 가지고 있는 사용자만 사용 가능한 페이지
			.antMatchers("/", "/**")
			.permitAll()
			// -> 인증 필요 없는 페이지
		.and()
//			.httpBasic() // 브라우저 기본 로그인 다이얼로그
			.formLogin(Customizer.withDefaults()) // 스프링에서 제공하는 기본 로그인 UI
		;
	}

}
