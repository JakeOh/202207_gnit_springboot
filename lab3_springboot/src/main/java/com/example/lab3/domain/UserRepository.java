package com.example.lab3.domain;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository 인터페이스를 상속하면 컴포넌트 애너테이션이 없어도
// 스프링 프레임워크에서 관리하는 객체(bean)가 됨.
// 기본적인 CRUD 메서드들을 가지고 있는 Repository 객체가 됨.
public interface UserRepository extends JpaRepository<User, Long> {

}
