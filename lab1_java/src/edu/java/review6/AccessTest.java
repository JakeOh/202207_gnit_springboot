package edu.java.review6;

public class AccessTest {
	private int a;
	int b;
	protected int c;
	public int d;
	
	// getter: 필드의 값을 리턴하는 메서드.
	public int getA() {
		return a;
	}
	
	// setter: 필드의 값을 변경하는 메서드.
	public void setA(int a) {
		this.a = a;
	}
	
}
