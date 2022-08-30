package com.example.lab3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.lab3.domain.Post;
import com.example.lab3.domain.PostRepository;
import com.example.lab3.dto.PostCreateDto;
import com.example.lab3.dto.PostResponseDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // 필수 argument를 갖는 생성자를 자동 생성
// final로 선언된 필드들을 argument로 갖는 생성자를 자동으로 만들어 줌.
@Service
// 스프링 컨텍스트가 관리하는 Bean(객체) - 스프링 프레임워크에서 생성/관리하고, 필요한 곳에 주입.
public class PostService {
	
	private final PostRepository postRepository;
	// @RequiredArgsConstructor + final 필드 => 생성자에 의한 의존성 주입.

	public Long create(PostCreateDto dto) {
		log.info("create(dto={})", dto);
		
		// postRepository 객체의 메서드를 사용해서 DB에 insert.
		Post entity = postRepository.save(dto.toEntity());
		log.info("entity={}", entity);
		
		return entity.getId(); // 작성된 포스트의 글번호를 리턴.
	}

	@Transactional(readOnly = true)
	public List<PostResponseDto> findAll() {
		log.info("findAll() 호출");
		
		// Repository를 이용해서 전체 검색
//		List<Post> allPosts = postRepository.findAll();
//		List<PostResponseDto> list = new ArrayList<>();
//		for (Post p : allPosts) {
//			list.add(new PostResponseDto(p));
//		}
//		return list;
		
		return postRepository.findByOrderByIdDesc() // List<Post> 타입을 리턴.
				.stream() // 스트림 생성 - 매핑, 필터링, 수집, ...
//				.map(post -> new PostResponseDto(post))
				.map(PostResponseDto::new) // Post 객체를 PostResponseDto 객체로 매핑.
				.collect(Collectors.toList()); // List 타입으로 수집.
	}

	// DB에서 검색(select)한 내용이 수정/삭제되지 않는 경우
	// readOnly=true로 설정하면 검색 속도가 더 빨라짐.
	@Transactional(readOnly = true)
	public Post read(Long id) {
		log.info("read(id={}) 호출", id);
		return postRepository.findById(id)
				.orElseThrow(() 
						-> new IllegalArgumentException("해당 아이디 포스트 없음."));
	}

	public Long delete(Long id) {
		log.info("delete(id={}) 호출", id);
		
		postRepository.deleteById(id); // id(PK)로 삭제.
		
		return id; // 삭제한 글번호를 리턴.
	}
	
}
