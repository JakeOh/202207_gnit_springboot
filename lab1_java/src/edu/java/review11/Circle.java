package edu.java.review11;

public class Circle extends Shape {
	private double r;
	
	public Circle(double r) {
		super("동그라미");
		this.r = r;
	}

	@Override
	public double area() {
		return Math.PI * r * r;
	}

	@Override
	public double perimeter() {
		return 2 * Math.PI * r;
	}
	
}
