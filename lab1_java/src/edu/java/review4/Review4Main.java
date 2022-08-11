package edu.java.review4;

public class Review4Main {

	public static void main(String[] args) {
		// for 반복문
		for (int i = 1; i < 5; i++) {
			System.out.println(i);
		}
		// 지역 변수: 메서드 안에서 선언된 변수
		// 지역 변수는 선언된 위치에서부터 변수가 속한 블록({...}) 안에서만 사용 가능!
		
		System.out.println("----------");
		for (int i = 3; i > 0; i--) {
			System.out.println(i);
		}
		
		System.out.println("----------");
		// 배열(array): 하나의 변수 이름에 같은 타입의 값들 여러개를 저장하기 위한 데이터 타입.
		String[] names = {"Scott", "Tiger", "King", "Allen"};
		System.out.println(names);

		// 배열에 저장된 원소들은 인덱스(index)를 이용해서 접근(사용)함.
		// 배열의 인덱스는 0부터 시작.
		System.out.println(names[0]);
		System.out.println(names[1]);
		System.out.println(names[2]);
		
		System.out.println("----------");
		// 배열이름.length: 배열의 길이(원소의 개수)
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		
		// 향상된 for 문(enhanced for statement), for-each 문
		System.out.println("----------");
		for (String s : names) {
			System.out.println(s);
		}
		
		// while 문
		System.out.println("----------");
		int i = 0;
		while (i < names.length) {
			System.out.println(names[i]);
			i++;
		}
		
	}

}
