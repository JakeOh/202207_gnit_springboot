package edu.java.review14;

// 함수형 인터페이스(functional interface): 추상 메서드를 오직 한 개만 가지고 있는 인터페이스.
// 자바 컴파일러에게 함수형 인터페이스인 지 아닌 지를 검사하도록 설정하는 애너테이션(annotation)
@FunctionalInterface
public interface Calculable {
	double calculate(double x, double y);
}
