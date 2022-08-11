package edu.java.review18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Review18Main {

	public static void main(String[] args) {
		// 정수들을 저장하는 리스트룰 생성.
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		System.out.println(numbers);
		
		// 리스트 numbers에서 홀수들만 출력
		for (Integer n : numbers) {  // 리스트의 원소들을 반복하면서
			if (n % 2 == 1) {  // 그 원소가 홀수이면
				System.out.println(n);  // 출력
			}
		}
		
		System.out.println("----");
		numbers.stream()  // list를 stream으로 만듦.
				.filter(x -> x % 2 == 1)  // 리스트의 원소 1개를 argument로 전달받아서 true/false 리턴하는 필터링 메서드 작성.
				.forEach(System.out::println);  // 필터링된 결과를 println 함수에게 전달.

		System.out.println("-----");
		
		// 리스트 numbers에서 짝수들의 제곱을 출력
		for (Integer n : numbers) {
			if (n % 2 == 0) {
				System.out.println(n * n);
			}
		}
		
		System.out.println("-----");
		numbers.stream()
				.filter(x -> x % 2 == 0)
				.forEach(x -> System.out.println(x * x));
		
		System.out.println("-----");
		numbers.stream()
				.filter(x -> x % 2 == 0)
				.mapToInt(x -> x * x)
				.forEach(System.out::println);
		
		System.out.println("-----");

		// 리스트 numbers에서 홀수들의 제곱의 합
		int sum = 0;  // 홀수들의 제곱을 더해나갈 변수.
		for (Integer n : numbers) {
			if (n % 2 == 1) {
				sum += n * n;
			}
		}
		System.out.println(sum);
		
		System.out.println("-----");
		sum = numbers.stream()
				.filter(x -> x % 2 == 1)
				.mapToInt(x -> x * x)
				.sum();
		System.out.println(sum);
		
		System.out.println("-----");
		
		// 리스트 numbers에서 홀수들의 제곱으로 이루어진 리스트를 만듦.
		List<Integer> oddSquares = numbers.stream()
				.filter(x -> x % 2 == 1)
				.map(x -> x * x)
				.collect(Collectors.toList());
		System.out.println(oddSquares);
		
		List<Integer> list = new ArrayList<>();
		for (Integer n : numbers) {
			if (n % 2 == 1) {
				list.add(n * n);
			}
		}
		System.out.println(list);
		
		numbers.stream().sorted().collect(Collectors.toList());
	}

}
