package edu.java.review7;

// Singleton design pattern
// 프로그램 전체에서 인스턴스를 오직 하나만 생성할 수 있도록 클래스를 작성하는 SW 디자인 패턴.

public class SingletonTest {
	
	// static field
	private static SingletonTest instance = null;
	// non-static field
	private String name;
	
	// private 생성자(constructor)
	// -> 다른 클래스에서는 객체 생성이 불가능.
	// -> 클래스 내부에서는 객체 생성이 가능.
	private SingletonTest(String name) {
		this.name = name;
	}

	// public static이고 리턴타입은 SingletonTest 타입의 메서드를 정의
	public static SingletonTest getInstance(String name) {
		if (instance == null) {  // 인스턴스가 생성되어 있지 않으면
			instance = new SingletonTest(name); // 인스턴스 생성
		}
		
		return instance;  // 생성된 인스턴스를 리턴.
	}
	
}
