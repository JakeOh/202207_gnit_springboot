package edu.java.review14;

public class Review14Main {

	public static void main(String[] args) {
		// 1. 인터페이스를 구현하는 (외부) 클래스를 사용.
		Calculable adder = new Adder();
		double result = adder.calculate(1, 2);
		System.out.println(result);
		
		// 2. (지역) 내부 클래스를 사용.
		class Subtracter implements Calculable {
			@Override
			public double calculate(double x, double y) {
				return x - y;
			}
		}
		Calculable subtracter = new Subtracter();
		result = subtracter.calculate(1, 2);
		System.out.println(result);
		
		// 3. 익명 (내부) 클래스를 사용
		Calculable multiplier = new Calculable() {
			@Override
			public double calculate(double x, double y) {
				return x * y;
			}
		};
		result = multiplier.calculate(1, 2);
		System.out.println(result);

		// 4. 람다 표현식(lambda expression):
		// 클래스 정의와 객체 생성을 동시에 하는 익명 클래스를 간단히 작성하기 위한 문법.
		// 함수형 인터페이스만 람다 표현식으로 작성할 수 있음.
		// (param, ...) -> { ... }
		// {...}에서 return 문만 있는 경우에는, (param, ...) -> 리턴값
		// 람다표현식에서 파라미터 타입은 생략할 수 있음.
		// {...}가 문장 하나만 있는 경우에는 중괄호({})를 생략할 수 있음.
		// 람다표현식에서 파라미터가 하나인 경우에는 ()를 생략할 수 있음.
		
//		Calculable divider = (x, y) -> { return x / y; };
		Calculable divider = (x, y) -> x / y;
		result = divider.calculate(1, 2);
		System.out.println(result);
		
		Calculable whoIsGreater = (x, y) -> {
			double rslt;  // 리턴값을 저장할 변수
			if (x > y) {
				rslt = x;
			} else {
				rslt = y;
			}
			return rslt;
		};
		result = whoIsGreater.calculate(1, 2);
		System.out.println(result);
		
		// 삼항 연산자: (조건식) ? 참일 때 선택할 값: 거짓일 때 선택할 값
		Calculable whoIsGreater2 = (x, y) -> (x > y) ? x : y;
		result = whoIsGreater2.calculate(1, 2);
		System.out.println(result);
		
		// (s) -> { System.out.println(s); }
		Printable printer = s -> System.out.println(s);
		printer.print("람다 표현식");
		
		// 메서드 참조(method reference)
		// (1) 람다 표현식의 파라미터가 한 개이고, 실행 문장도 한 개인 경우에,
		// 파라미터가 실행 문자의 argument로 그대로 전달되는 경우.\
		Printable printer2 = System.out::println;
		printer2.print("메서드 참조 1");
		
		Transformer trans = s -> s.length();
		System.out.println(trans.toInt("문자열 길이"));
		
		// 메서드 참조
		// (2) 람다 표현식의 파라미터가 한 개이고, 실행 문장도 한 개인 경우에,
		// 그 실행 문장이 파라미터에서 메서드를 호출하는 문장인 경우.
		Transformer trans2 = String::length;
		System.out.println(trans2.toInt("method ref"));
	}

}
