package edu.java.review12;

// Java 버전에 따른 interface(인터페이스) 변화
// 1. Java 7 버전까지
//    - public static final 필드
//    - public abstract 메서드
// 2. Java 8 버전
//    - public static final 필드
//    - public abstract 메서드
//    - (public) default 메서드 - 하위 클래스의 객체가 생성되어야 사용할 수 있는 메서드.
//    - (public) static 메서드 - 인터페이스 이름으로 호출할 수 있는 메서드.
// 3. Java 9 버전부터
//    - Java 8 버전까지의 멤버들
//    - private static 메서드, private (body가 있는) 메서드
// Java의 클래스는 다중 상속을 제공하지 않음. 한 개의 클래스만 상속할 수 있음!
// 인터페이스 구현(implements)에서는 인터페이스 개수 제한이 없음.

class SuperClass1 {}
class SuperClass2 {}
interface Interface1 {}
interface Interface2 {}

// class SubClass extends SuperClass1, SuperClass2 {}
// -> 클래스는 다중 상속을 할 수 없음!

class SubClass implements Interface1, Interface2 {}
// -> 인터페이스는 2개 이상을 구현할 수 있음.

// 하위 클래스가 상위 클래스를 상속받고, 인터페이스도 구현하는 경우:
class SubClass2 extends SuperClass1 
		implements Interface1 {
	// TODO
}

public class Review12Main {

	public static void main(String[] args) {
		DatabaseModule db = new OracleDatabaseModule();
		int result = db.insert("test");
		System.out.println(result);
		
		String s = db.select();
		System.out.println(s);

		Customer customer = new Customer();
		customer.order();
		
	}

}
