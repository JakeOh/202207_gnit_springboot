package com.example.lab3.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PostRepositoryTest {
	
	@Autowired  // 의존성 주입(dependency injection), IoC(Inversion of Control, 제어의 역전)
	private PostRepository postRepo;
	
	@Test
	public void insertPostTest() {
		Post entity = Post.builder()
				.author("admin")
				.content("포스트 입력 테스트")
				.title("테스트1")
				.build();
		log.info("insert 전:" + entity.toString());
		
		postRepo.save(entity);
		log.info("insert 후:" + entity.toString());
		
		assertNotNull(entity.getId());
		assertNotNull(entity.getCreatedDate());
		assertNotNull(entity.getModifiedDate());
		
		List<Post> list = postRepo.findAll();
		log.info(list.toString());
	}

}
