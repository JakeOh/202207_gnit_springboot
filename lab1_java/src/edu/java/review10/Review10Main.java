package edu.java.review10;

// final: 클래스, 멤버(필드, 메서드), 지역 변수에서 사용하는 수식어. 변하지 않음.
// 1. final 지역 변수: 값을 한번만 초기화할 수 있고, 변경할 수 없는 지역 변수
// 2. final 필드: 반드시 한 번 초기화를 해야하고, 초기화한 이후에는 값을 변경할 수 없는 클래스의 속성. 
// 3. final 메서드: Sub class에서 override를 할 수 없는 메서드.
// 4. final 클래스: 상속을 할 수 없는 클래스.

class A {
	public void test1() {}
	public final void test2() {}
}
class B extends A {
	@Override
	public void test1() {}
	
//	@Override
//	public final void test2() {}
}

final class C {}
//class D extends C {}

public class Review10Main {
	// final field: 반드시 한 번 초기화(initialization)을 해야 함.
	//   (1) 선언 시점에 초기화
	//   (2) argument를 갖는 생성자를 정의
	// private final String name = "test";  // (1)
	private final String name;
	
	// (2)
	public Review10Main(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		final int n = 1;  // 지역 변수
		// n = 10;  // final 변수는 한번만 초기화할 수 있음.

		Review10Main app = new Review10Main("TEST");
		System.out.println(app.name);
		
	}

}
