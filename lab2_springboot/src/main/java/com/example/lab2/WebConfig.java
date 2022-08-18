package com.example.lab2;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// 특별한 템플릿 없는 정적인 페이지와 요청 주소를 매핑
		registry.addViewController("/").setViewName("index");
	}
	
}
