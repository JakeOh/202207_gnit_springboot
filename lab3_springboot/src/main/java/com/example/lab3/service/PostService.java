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
import com.example.lab3.dto.PostUpdateDto;

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

	@Transactional
	public Post update(Long id, PostUpdateDto dto) {
		log.info("update(id={}, dto={})", id, dto);
		
		// 포스트 번호 id(PK)로 DB에서 포스트를 검색.
		Post entity = postRepository.findById(id).orElseThrow();
		
		// -> 검색된 포스트의 내용을 dto의 title과 content로 수정.
		entity.update(dto);
		
		// 메서드 이름 앞에 @Transactional 애너테이션을 사용하면,
		// postRepository의 save(entity) 메서드를 호출하지 않아도
		// 트랜잭션이 끝나는 시점에 자동으로 DB에 저장됨.
		
		return entity;
	}

	@Transactional(readOnly = false)
	public List<PostResponseDto> search(String type, String keyword) {
		log.info("search(type={}, keyword={})", type, keyword);
		
		// 검색 타입에 따라서 서로 다른 쿼리(repository 메서드)를 호출.
		List<Post> searchResult = null;
		switch (type) {
		case "t": // 제목 검색
			searchResult = postRepository
			.findByTitleContainingIgnoreCaseOrderByIdDesc(keyword);
			break;
		case "c": // 내용 검색
			searchResult = postRepository
			.findByContentContainingIgnoreCaseOrderByIdDesc(keyword);
			break;
		case "tc": // 제목+내용 검색
			searchResult = postRepository
			.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCaseOrderByIdDesc(keyword, keyword);
			break;
		case "a": // 작성자 검색
			searchResult = postRepository
			.findByAuthorContainingIgnoreCaseOrderByIdDesc(keyword);
			break;
		default:
			searchResult = new ArrayList<>();
		}
		
		return searchResult // List<Post>
				.stream() // Stream 객체 변환
				.map(PostResponseDto::new) // Stream 반복하면서 Post -> PostResponseDto
				.collect(Collectors.toList()); // mapping 결과를 List로 수집.
	}
	
}
