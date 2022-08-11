package edu.java.review13;

public class Outer {
	// field
	private int x;
	private int y;
	
	// constructor
	public Outer(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// method
	public void printOuter() {
		System.out.println("x = " + this.x);
		System.out.println("y = " + this.y);
	}

	public Inner inner(int z) {
		return new Inner(z);
	}
	
	// 인스턴스 멤버 내부 클래스
	public class Inner {
		// field
		private int z;
		
		// constructor
		public Inner(int z) {
			this.z = z;
		}
		
		// method
		public void printInner() {
			// 내부 클래스는 외부 클래스의 모든 멤버들을 참조할 수 있음.
			printOuter();  // 외부 클래스의 메서드를 호출.
			System.out.println("x = " + x);  // 외부 클래스의 필드 참조.
			System.out.println("z = " + z);
		}
	}
}
