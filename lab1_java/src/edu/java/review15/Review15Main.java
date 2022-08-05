package edu.java.review15;

import java.util.ArrayList;
import java.util.List;

public class Review15Main {

	public static void main(String[] args) {
		// 배열(array): 한 가지 타입의 값들을 여러개 저장할 수 있는 데이터 타입.
		// 배열의 단점: 배열이 처음 생성될 때의 배열의 길이를 변경할 수 없음.
		String[] names = {"Scott", "Tiger"};
		int[] integers = {1, 2, 3};
		System.out.println(integers);
		System.out.println(integers[2]);
//		integers[3] = 100;
		
		// 리스트(list): 배열과 비슷한데, 원소들을 추가/삭제할 수 있는 데이터 타입.
		List<Integer> numbers = new ArrayList<>();  // ArrayList 객체 생성
		System.out.println(numbers);
		System.out.println(numbers.size());  // 리스트의 원소 개수
		numbers.add(1);  // List.add(e) - 리스트에 새로운 원소 추가.
		numbers.add(3);
		numbers.add(5);
		System.out.println(numbers);
		System.out.println(numbers.size());
		
		// List.get(i) - 리스트에서 인덱스 i 위치의 원소를 리턴.
		// 배열과 리스트의 인덱스는 0부터 시작.
		System.out.println(numbers.get(2));
		
		// List.remove(i) - 리스트에서 인덱스 i 위치의 원소를 삭제.
		numbers.remove(1);
		System.out.println(numbers);
		System.out.println(numbers.size());
		
		// List.remove(o) - 리스트에서 값이 o인 원소를 삭제.
		numbers.remove(Integer.valueOf(1));
		System.out.println(numbers);
		
		// 문자열을 저장하는 ArrayList를 생성
		List<String> strings = new ArrayList<>();
		System.out.println(strings.size());
		
		// 리스트에 문자열들을 추가
		strings.add("Java");
		strings.add("JavaScript");
		strings.add("Java");
		strings.add("JavaScript");
		System.out.println(strings);
		
		// 리스트에서 인덱스 i번째의 원소 읽기.
		System.out.println(strings.get(0));
		
		// 인덱스로 삭제.
		strings.remove(0);
		System.out.println(strings);
		
		// 값으로 삭제.
		strings.remove("JavaScript");
		System.out.println(strings);
		
	}

}
