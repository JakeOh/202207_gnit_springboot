package edu.java.review9;

// 상속(inheritance): 상위 클래스의 멤버들을 확장해서 하위 클래스를 설계하는 방법.
// 상위 클래스(super class), 부모 클래스(parent class), 기본 클래스(base class)
// 하위 클래스(sub class), 자식 클래스(child class), 유도 클래스(derived class)
// IS-A 관계 성립할 때 상속을 사용해서 클래스를 설계.
//   회사원은 사람이다.(Business person IS A person.)
//   학생은 사람이다.(Student IS A person.)
//   Person - super class, BusinessPerson/Student - sub class
// Java의 모든 클래스는 Object 클래스를 상속함. extends Object는 보통 생략.

public class Review9Main {

	public static void main(String[] args) {
		// Person 기본 생성자 호출
		Person p1 = new Person();
		System.out.println(p1);
		System.out.println(p1.toString());
		// println 메서드는 객체의 toString() 메서드가 리턴하는 문자열을
		// 콘솔 창에 프린트함.
		// 모든 객체는 Object 클래스로부터 toString() 메서드를 상속받음.

		// Person 클래스의 argument를 갖는 생성자 호출
		Person p2 = new Person("홍길동");
		System.out.println(p2);
		
		// BusinessPerson 클래스의 기본 생성자 호출
		BusinessPerson p3 = new BusinessPerson();
		
		// BusinessPerson 클래스의 argument를 갖는 생성자 호출
		BusinessPerson p4 = new BusinessPerson("홍길동", "강남아이티");
		System.out.println(p4);
		System.out.println(p4.getName()); // 부모 Person에서 상속한 메서드를 사용.
		System.out.println(p4.getCompany());  // BusinessPerson에서 정의한 메서드 사용.
		
		
	}

}
