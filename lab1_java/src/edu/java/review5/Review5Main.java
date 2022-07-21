package edu.java.review5;

// OOP(Object-Oriented Programming, 객체지향 프로그래밍)
// 객체(Object): 프로그램에서 만들려고 하는 대상. 속성(데이터)과 기능을 가질 수 있음.
// 클래스(Class): 객체를 만들기 위해서 프로그래밍 언어로 작성하는 코드.
//   객체를 만들기 위한 설계도.
//   필드(field, 속성 property, 멤버 변수) + 생성자(constructor) + 메서드(method)
//   클래스는 데이터 타입: 변수 선언에서 사용.
// 인스턴스(Instance): 클래스를 사용해서 메모리에 생성된 객체.

// 클래스 선언(정의)
// [수식어] class ClassName {...}

public class Review5Main {
	
	public static void main(String[] args) {
		// Employee 클래스의 객체를 생성 -> 인스턴스
		Employee emp1 = new Employee();  // 기본 생성자 호출
		System.out.println(emp1);
		System.out.println(emp1.empNo);
		System.out.println(emp1.empName);
		System.out.println(emp1.salary);

		// argument들을 갖는 생성자 호출.
		Employee emp2 = new Employee(1, "홍길동", 1000.0);
		System.out.println(emp2);
		System.out.println(emp2.empNo);
		System.out.println(emp2.empName);
		System.out.println(emp2.salary);
		
		// 인스턴스의 메서드를 호출.
		double sal = emp2.raiseSalary(0.1);
		System.out.println(sal);
		emp2.printEmpInfo();
		
		emp1.printEmpInfo();
		
	}

}
