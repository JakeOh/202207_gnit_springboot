package edu.java.review9;

// class SubClass extends SuperClass
public class BusinessPerson extends Person {
	// field
	private String company;
	
	// 생성자
	public BusinessPerson() {
//		super();
		System.out.println("BusinessPerson() 생성자");
	}
	
	public BusinessPerson(String name, String company) {
		// Super class의 argument를 갖는 생성자를 명시적으로 호출.
		super(name);
		this.company = company;
		System.out.println("BusinessPerson(name, company) 생성자");
	}

	// 상속 관계에서의 생성자가 호출되는 순서:
	// 1. 하위 클래스의 생성자를 호출하면, 상위 클래스의 생성자가 먼저 실행됨.
	// 2. 하위 클래스의 생성자에서 상위 클래스의 생성자를 명시적으로 호출하지 않으면,
	// 상위 클래스의 기본 생성자(super();)가 자동으로(implicitly) 호출됨.
	// 3. 하위 클래스의 생성자에서 상위 클래스의 생성자를 명시적으로 호출할 수도 있음.
	// super(); 또는 super(param, ...); 형식으로 호출.
	// super()는 생성자 코드에서 가장 먼저 호출되어야 함.
	// 4. 상위 클래스가 기본 생성자를 갖고 있지 않을 때에는
	// 하위 클래스의 생성자에서는 상위 클래스의 생성자를 반드시 명시적으로(explicitly) 호출해야 함!
	
	// getter/setter 메서드
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	// 상위 클래스인 Person의 toString() 메서드를 override
	@Override
	public String toString() {
		return String.format("이름: %s, 회사: %s", 
				getName(), this.company);
	}
}
