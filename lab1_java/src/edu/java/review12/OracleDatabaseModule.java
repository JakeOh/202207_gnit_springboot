package edu.java.review12;

// (클래스) 상속: class SubClass extends SuperClass
// (인터페이스) 구현: class SubClass implements Interface 
public class OracleDatabaseModule implements DatabaseModule {

	@Override
	public int insert(String s) {
		System.out.println("Oracle insert: " + s);
		return 1;
	}

	@Override
	public String select() {
		return "Oracle select result";
	}

}
