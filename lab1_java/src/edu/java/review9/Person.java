package edu.java.review9;

public class Person {
	// field
	private String name;
	
	// constructor
	public Person() {
		System.out.println("Person() 생성자");
	}
	
	public Person(String name) {
		this.name = name;
		System.out.println("Person(name) 생성자");
	}

	// getter/setter 메서드
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	// overload: 같은 이름으로 메서드 (또는 생성자)를 여러개 정의하는 것.
	
	// override: 상위 클래스가 가지고 있는 메서드를 하위 클래스에서 재정의 하는 것.
	// 상위 클래스에서의 메서드 이름, 리턴 타입, 파라미터 선언이 모두 일치해야 함.
	// 접근 수식어는 상위 클래스보다 같거나 더 넓어져야 함.
	
	// Person의 상위 클래스인 Object가 가지고 있는 toString() 메서드를 override
	@Override  // 자바 컴파일러에게 override 메서드임을 알려줌.
	public String toString() {
		return "이름: " + this.name;
	}
}
