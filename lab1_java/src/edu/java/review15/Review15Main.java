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

		// 리스트(list): 배열과 비슷한데, 원소들을 추가/삭제할 수 있는 데이터 타입.
		List<Integer> numbers = new ArrayList<>();  // ArrayList 객체 생성
		System.out.println(numbers);
		System.out.println(numbers.size());  // 리스트의 원소 개수
		numbers.add(1);
		numbers.add(3);
		numbers.add(5);
		System.out.println(numbers);
		
	}

}
