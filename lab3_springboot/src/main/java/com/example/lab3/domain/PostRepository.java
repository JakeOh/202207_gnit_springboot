package com.example.lab3.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// CRUD(Create, Read, Update, Delete): insert, select, update, delete
// Post 엔터티의 CRUD 작업을 담당하는 객체.

// JpaRepository<Entity, Id> 상속받는 인터페이스를 작성.
// -> @Repository 애너테이션이 없어도 스프링 프레임워크에서 component scan이 가능해짐. 
public interface PostRepository extends JpaRepository<Post, Long> {

	// posts 테이블 내용 전체 검색, id(글번호) 내림차순 정렬
	// select * from posts order by id desc;
	List<Post> findByOrderByIdDesc();
	
	// 검색에 필요한 메서드 signature 정의
	// (1) 제목 검색
	// select * from POSTS
	// where lower(TITLE) like lower(?)
	// order by ID desc;
	List<Post> findByTitleContainingIgnoreCaseOrderByIdDesc(String title);
	
	// (2) 내용 검색
	// select * from POSTS
	// where lower(CONTENT) like lower(?)
	// order by ID desc;
	List<Post> findByContentContainingIgnoreCaseOrderByIdDesc(String content);
	
	// (3) 작성자 검색
	// select * from POSTS
	// where lower(AUTHOR) like lower(?)
	// order by ID desc;
	List<Post> findByAuthorContainingIgnoreCaseOrderByIdDesc(String author);

	// (4) 제목+내용 검색
	// select * from POSTS
	// where lower(TITLE) like lower(?)
	//    or lower(CONTENT) like lower(?)
	// order by ID desc;
	List<Post> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCaseOrderByIdDesc(String title, String content);

}
