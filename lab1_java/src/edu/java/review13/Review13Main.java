package edu.java.review13;

import edu.java.review13.Outer.Inner;
import edu.java.review13.EnclosingCls.NestedCls;

// Java에서 변수 선언:
// 1. 필드(멤버 변수)
//    (1) 인스턴스 필드: static이 아닌 필드
//    (2) static 필드
// 2. 지역 변수

// 내부 클래스를 선언(정의):
// 1. 멤버 내부 클래스: 필드를 선언하는 위치에서 선언하는 내부 클래스.
//    (1) 인스턴스 내부 클래스
//    (2) static 내부 클래스
// 2. 지역 내부 클래스: 메서드 안에서 선언하는 내부 클래스.
// 3. 익명 클래스(anonymous class): 이름이 없는 내부 클래스.
// 외부 클래스의 가시성(visibility)는 public과 package만 가능하지만,
// 멤버 내부 클래스의 가시성은 private, package, protected, public 모두 가능.

public class Review13Main {
	private int x;  // 인스턴스 필드(멤버 변수)
	public static int y = 100;  // 클래스 필드(멤버 변수)

	public static void main(String[] args) {
		int x = 10; // 지역 변수
		
		// 1. 외부 클래스 객체 생성
		Outer outer = new Outer(1, 2);
		outer.printOuter();
		
		// 2. 인스턴스 내부 클래스 객체 생성
		Outer.Inner inner1 = outer.new Inner(3);
		inner1.printInner();
		
		// import문이 있기 때문에 Outer.Inner를 간단히 Inner로 쓸 수 있음.
		Inner inner2 = outer.inner(5);
		
		// 3. static 내부 클래스 객체 생성
		// 외부 클래스의 인스턴스 생성 여부와 상관없이 객체 생성(생성자 호출)이 가능
		EnclosingCls.NestedCls nested = new EnclosingCls.NestedCls("abc");
		nested.test();
		
		// import 문이 있기 때문에 NestedCls라고 간단히 쓸 수 있음. 
		NestedCls nested2 = new NestedCls("TEST");
		
		// 4. 지역 내부 클래스 - 메서드 안에서 선언하는 클래스
		class SaveButton implements Button {
			@Override
			public void click() {
				System.out.println("저장");
			}
		}
		SaveButton btn = new SaveButton();
		btn.click();
		
		// 5. 익명 클래스(anonymous class)
		// 부모(super) 타입으로 생성자를 호출하면서 클래스를 정의하는 것.
		// 클래스 정의와 객체 생성을 동시에. 
		Button btnFileOpen = new Button() {
			@Override
			public void click() {
				System.out.println("파일 열기");
			}
		};
		btnFileOpen.click();
		
		// test 메서드 호출
		test("내부 클래스 테스트", new SaveButton());
		test("익명 클래스 테스트", new Button() {
			@Override
			public void click() {
				System.out.println("파일 저장");
			}
		});
		
	}
	
	private static void test(String desc, Button btn) {
		System.out.println(desc);
		btn.click();
	}
	
}
