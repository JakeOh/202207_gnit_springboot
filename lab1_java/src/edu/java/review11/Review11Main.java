package edu.java.review11;

// 클래스: 필드(속성) + 생성자 + 메서드(기능) ==> 데이터 타입(type)
// 추상 메서드(abstract method): 
//   메서드의 signature(리턴타입, 메서드 이름, 파라미터 선언)만 선언하고, 본체(body)를 정의하지 않은 메서드.
//   메서드를 선언할 때 {...} 부분이 없음.
//   추상 메서드 선언은 반드시 세미콜론(;)으로 끝냄.
//   abstract 키워드를 사용.
// 추상 클래스(abstract class):
//   abstract로 선언된 클래스
//   객체를 생성할 수 없음(생성자를 호출할 수 없음).

public class Review11Main {

	public static void main(String[] args) {
//		Shape s = new Shape("사각형");
		
		Shape rect = new Rectangle(3, 4); // 다형성
		rect.draw();
		
		Shape circle = new Circle(1);
		circle.draw();

	}

}
