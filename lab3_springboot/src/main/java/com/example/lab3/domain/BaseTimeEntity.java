package com.example.lab3.domain;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

// JPA(Java Persistence API, 자바 영속성 API) auditing 기능을 사용해서 생성/수정 시간을 자동으로 기록:
// 1. BaseTimeEntity 클래스 작성 - @MappedSuperclass, @EntityListeners
// 2. 날짜/시간이 필요한 엔터티 클래스(들)에서 BaseTimeEntity를 상속함.
// 3. JPA auditing 기능을 활성화(enable) - Main 클래스에서.

@Getter
@MappedSuperclass // BaseTimeEntity를 상속하는 하위 클래스들이 생성 시간, 수정 시간 컬럼을 갖도록.
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
	
	@CreatedDate // 엔터티가 생성되서 테이블에 insert될 때의 시간이 자동으로 기록.
	private LocalDateTime createdDate; // 최초 생성 시간

	@LastModifiedDate // select한 엔터티의 필드 값들이 변경될 때의 시간이 자동으로 기록.
	private LocalDateTime modifiedDate; // 최종 수정 시간

}
