package edu.java.review6;

import edu.java.review5.Employee;

// 클래스 멤버의 접근 수식어(access modifier)
// 1. 종류: private, (package), protected, public
// 2. 기능: 클래스 멤버(필드, 생성자, 메서드)의 접근 권한을 설정.
// 3. 의미:
//    (1) private: 선언된 클래스 안에서만 직접 접근(사용) 가능.
//    (2) (package): 같은 패키지의 클래스들에서 직접 접근(사용) 가능.
//    (3) protected: 같은 패키지에 있거나 또는 상속하는 클래스에서 직접 접근(사용) 가능.
//    (4) public: 어디서든지 접근(사용) 가능.
// 4. 사용 범위: private < (package) < protected < public

// 클래스 접근 수식어: public, (package)
// public class: 어디서나 보이는(변수 선언 가능한) 클래스.
// (package) class: 같은 패키지에서만 보이는 클래스.
// public class의 이름은 java 파일의 이름과 같아야 함!
// 한 개의 java 파일 안에서 public 클래스는 오직 한 개만 정의 가능.
// 한 개의 java 파일 안에 package 클래스는 한 개 이상이 있을 수 있음. - 권장하지 않음.
class A {}
class B {}

public class Review6Main {

	public static void main(String[] args) {
		// edu.java.review5.Employee 클래스 객체 생성
		// Ctrl+Shift+O: import 문 optimize
		Employee emp = new Employee(1, "홍길동", 1000);
//		System.out.println(emp.empNo);
//		emp.salary = 2000;
		// not visible: package로 선언된 멤버는 다른 패키지의 클래스에서 사용 불가.

		emp.printEmpInfo();
		// public으로 공개된 메서드는 사용 가능.
		
		AccessTest test = new AccessTest();
		System.out.println(test);
//		System.out.println(test.a);  // not visible
		System.out.println(test.b);
		
		// private으로 감춰진 필드의 값을 public으로 공개된 setter를 사용해서 변경.
		test.setA(123);
		// private으로 감춰진 필드의 값을 public을 공개된 getter를 사용해서 읽어옴.
		System.out.println(test.getA());
	}

}
