package edu.java.review11;

public class Rectangle extends Shape {
	private double width;
	private double height;

	public Rectangle(double width, double height) {
		super("직사각형");
		this.width = width;
		this.height = height;
	}

	// 추상 메서드 구현(implementation)
	@Override
	public double area() {
		return width * height;
	}

	@Override
	public double perimeter() {
		return 2 * (width + height);
	}
	
}
