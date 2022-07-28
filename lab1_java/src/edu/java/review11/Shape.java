package edu.java.review11;

// 추상 클래스
public abstract class Shape {
	private String name;
	
	public Shape(String name) {
		this.name = name;
	}
	
	// 추상 메서드
	public abstract double area();
	public abstract double perimeter();
	
	// 메서드
	public void draw() {
		String info = String.format("%s(넓이=%f, 둘레=%f)", 
				name, area(), perimeter());
		System.out.println(info);
	}
}
