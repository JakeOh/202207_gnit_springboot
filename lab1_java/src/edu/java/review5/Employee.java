package edu.java.review5;

public class Employee {
	// 객체의 속성들을 선언 - field, property, 멤버 변수
	int empNo;  // 사번
	String empName; // 이름
	double salary; // 급여

	// 클래스를 작성할 때 생성자를 "하나도" 만들지 않으면
	// 자바 컴파일러가 기본 생성자(default constructor)를 자동으로 만들어 줌.
	// 기본 생성자: 모든 필드를 기본값(0, 0.0, false, null)로 초기화하는 생성자.
	// 생성자의 이름은 클래스의 이름과 동일.
	// 생성자는 리턴 타입을 갖지 않음! void도 사용하지 않음!
	
	// 기본 생성자. argument를 갖지 않는 생성자.
	public Employee() {}
	
	// argument를 갖는 생성자.
	public Employee(int empNo, String empName, double salary) {
		this.empNo = empNo;
		this.empName = empName;
		this.salary = salary;
	}
	
	public Employee(int empNo) {
//		this.empNo = empNo;
//		this.empName = null;
//		this.salary = 0.0;
		
		// 같은 클래스의 다른 생성자를 호출
		this(empNo, null, 0);
	}
	
	public Employee(int empNo, String empName) {
		this(empNo, empName, 0);
	}
	
	// parameter(매개변수): 생성자 또는 메서드에서 argument를 저장하기 위해 선언하는 변수.
	// parameter의 타입, 개수, 순서가 다른 경우에만 같은 이름으로 여러개의 
	// 메서드 (또는 생성자)를 정의할 수 있음 - overload. 
	
	// 객체의 기능(function) - 메서드(method)
	// [수식어] 리턴타입 메서드이름([파라미터 선언]) {...}
	public double raiseSalary(double ratio) {
		this.salary += this.salary * ratio;
		
		// 메서드를 호출한 곳으로 값을 반환(return)
		return this.salary;
	}
	
	// void: 리턴 값이 없음.
	public void printEmpInfo() {
		String info = "사번: " + this.empNo
				+ ", 이름: " + this.empName
				+ ", 급여: " + this.salary;
		System.out.println(info);
	}
	
}
