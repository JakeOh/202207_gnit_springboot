package edu.java.review13;

public class EnclosingCls {
	// field
	private int instanceVar;
	public static int classVar = 1;
	
	// constructor
	public EnclosingCls(int instanceVar) {
		this.instanceVar = instanceVar;
	}
	
	// instance method
	public void instanceMethod() {
		System.out.println("인스턴스 메서드");
		System.out.println("instanceVar = " + instanceVar);
		System.out.println("classVar = " + classVar);
	}
	
	// class method
	public static void classMethod() {
		System.out.println("클래스 메서드");
		System.out.println("classVar = " + classVar);
	}

	// static 내부 클래스(중첩 클래스, nested class)
	public static class NestedCls {
		private String name;
		
		public NestedCls(String name) {
			this.name = name;
		}
		
		public void test() {
			System.out.println("중첩 클래스 메서드");
			System.out.println("name=" + name);
			System.out.println("classVar=" + classVar);
		}
	}
	
}
