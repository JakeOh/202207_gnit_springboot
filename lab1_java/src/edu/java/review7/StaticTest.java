package edu.java.review7;

public class StaticTest {
	static int number1;
	int number2;
	
	static void printInfo() {
		System.out.println("number1 = " + number1);
//		System.out.println("number2 = " + number2);
		// 객체 생성 전에 호출 가능해야 하므로 number2를 참조할 수 없다.
		// number2는 객체가 생성되야 메모리에 생기는 변수이기 때문에.
	}
	
	void printInfo2() {
		System.out.println("number1 = " + number1);
		System.out.println("number2 = " + number2);
		// 인스턴스 메서드는 static 또는 non-static 모두 참조할 수 있음.
	}

}
