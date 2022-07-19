package edu.java.review1;  // 패키지 선언문

public class Review1Main {

	// main 메서드(method): 프로그램의 시작점.
	public static void main(String[] args) {
		System.out.println("안녕하세요, Java!");
		System.out.println("Ctrl+Space: 코드 추천/자동완성");
		System.out.println("Ctrl+F11: 프로그램 실행(Run)");
//		System.out.println("Ctrl+/: 현재 커서 위치 한 줄을 주석 toggle");
		
		// 변수 선언과 초기화
		// 변수타입 변수이름 = 값;
		int number = 3;
		String message = "Hello, Java!";
		System.out.println(number);
		System.out.println(message);
		
//		int number = 5;  // 같은 이름으로 변수를 두번 이상 선언할 수 없음.
		number = 5;  // 이미 선언된 변수의 값을 변경.
		
		// Java의 기본 데이터 타입:
		// 정수: byte, short, int, long, char
		// 실수: float, double
		// 논릿값: boolean
		// 객체 타입: String, List, ...
	}

}
