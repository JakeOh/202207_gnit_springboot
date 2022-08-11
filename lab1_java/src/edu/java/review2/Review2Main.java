package edu.java.review2;

public class Review2Main {

	public static void main(String[] args) {
		// 연산자(operator)
		// 할당 연산자: =
		// 산술 연산자: +, -, *(곱셈), /(나눗셈), %(나머지)
		// 정수/정수=몫, 실수/실수=소수점이하 계산.
		// 복합 할당 연산자: +=, -=, *=, /=, %=, ...
		// 증감 연산자: ++, --
		// 비교 연산자: ==, !=, >, >=, <, <=
		// 논리 연산자: &&(and), ||(or), !(not)
		
		// 조건문(conditional statement)
		int number = 11;
		if (number % 2 == 0) { // number를 2로 나눈 나머지가 0과 같으면(짝수이면)
			System.out.println("짝수");
		} else { // 그렇지 않으면(짝수가 아니면, 홀수이면)
			System.out.println("홀수");
		}
		System.out.println("if-else end");
		
		if (number % 2 == 0) {
			System.out.println("짝수");
		}
		System.out.println("if-else end");
		
		number = 0;
		if (number > 0) {
			System.out.println("양수");
		} else if (number < 0) {
			System.out.println("음수");
		} else {
			System.out.println("영");
		}
		
		if (number > 0) {
			System.out.println("positive number");
		} else {
			if (number < 0) {
				System.out.println("negative number");
			} else {
				System.out.println();
			}
		}
		
	}

}
