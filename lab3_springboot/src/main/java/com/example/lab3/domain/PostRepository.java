package com.example.lab3.domain;

import org.springframework.data.jpa.repository.JpaRepository;

// CRUD(Create, Read, Update, Delete): insert, select, update, delete
// Post 엔터티의 CRUD 작업을 담당하는 객체.

// JpaRepository<Entity, Id> 상속받는 인터페이스를 작성.
// -> @Repository 애너테이션이 없어도 스프링 프레임워크에서 component scan이 가능해짐. 
public interface PostRepository extends JpaRepository<Post, Long> {

}
