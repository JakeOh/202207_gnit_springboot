package edu.java.review7;

// static: 멤버(필드, 메서드, 클래스) 선언에서 사용하는 수식어. 지역 변수에는 사용할 수 없다.
// 객체가 생성되기 전에 (프로그램 실행 시점에) 메모리에 로딩되는 필드 또는 메서드.
// static 변수(클래스 변수): 인스턴스를 생성하지 않아도 사용 가능.
//	ClassName.fieldName 형식으로 사용.
// static 메서드(클래스 메서드): 인스턴스를 생성하지 않아도 사용 가능.
//	ClassName.methodName(arg, ...);

public class Review7Main {
	
	public static void main(String[] args) {
		// static 필드와 메서드 예: Math 클래스.
		System.out.println(Math.E);
		System.out.println(Math.PI);
		System.out.println(Math.sqrt(2));
		
		// static 변수, 메서드 사용
		System.out.println(StaticTest.number1);
		StaticTest.number1 = 100;
		StaticTest.printInfo();
		
		// 인스턴스 필드, 메서드 사용 <- 인스턴스 생성 후
		StaticTest test = new StaticTest();  // static이 아닌 멤버들만 초기화.
		System.out.println(test.number1);  // 권장하지 않는 방법
		test.printInfo2();

		// singleton 디자인 패턴 테스트
		SingletonTest singlton1 = SingletonTest.getInstance("test");
		System.out.println(singlton1);
		
		SingletonTest singlton2 = SingletonTest.getInstance("test");
		System.out.println(singlton2);
		
	}

}
