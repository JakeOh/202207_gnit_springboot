package edu.java.review16;

import java.util.HashMap;
import java.util.Map;

public class Review16Main {

	public static void main(String[] args) {
		// Map: key(키)-value(값) 쌍으로 데이터를 저장하는 타입.
		Map<Integer, String> students = new HashMap<>();
		System.out.println(students);
		System.out.println(students.size());
		
		// Map.put(key, value) - Map에 원소(key-value)를 추가.
		students.put(10, "홍길동");
		students.put(1, "Scott");
		System.out.println(students);
		System.out.println(students.size());
		
		// Map.get(key) - Map에서 key에 해당하는 값(value)을 리턴.
		System.out.println(students.get(10));
		
		// Map.keySet() - Map이 가지고 있는 키들의 집합을 리턴.
		System.out.println(students.keySet());
		for (Integer key : students.keySet()) {
			System.out.println(students.get(key));
		}
		
		// Map.remove(key) - 해당 key의 원소(key-value 쌍)을 삭제
		students.remove(1);
		System.out.println(students);
		
	}

}
