package com.example.lab3.domain;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
@Entity(name = "USERS")
public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; // PK
	
	@Column(nullable = false, unique = true)
	private String username; // 사용자 아이디
	
	@Column(nullable = false)
	private String password; // 비밀번호
	
	@Column(nullable = false)
	private String email;

	@Builder
	private User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	// UserDetails 인터페이스를 구현할 때 재정의해야 하는 메서드들.
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// 사용자 계정이 가지고 있는 권한(authority)들의 리스트를 리턴.
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public boolean isAccountNonExpired() {
		return true; // 계정이 non-expired(만료되지 않음)
	}

	@Override
	public boolean isAccountNonLocked() {
		return true; // 계정이 non-locked(잠기지 않음)
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true; // 비밀번호가 non-expired(만료되지 않음)
	}

	@Override
	public boolean isEnabled() {
		return true; // 사용가능.
	}

}
