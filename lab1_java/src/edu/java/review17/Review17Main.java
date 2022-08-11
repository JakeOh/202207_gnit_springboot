package edu.java.review17;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// generic class 정의하는 방법
class Box<T> {
	private T element;
	
	public Box() {}
	public Box(T element) {
		this.element = element;
	}
	
	public void add(T element) {
		this.element = element;
	}
	
	public T get() {
		return this.element;
	}
}

class Dictionary<K, V> {
	private K key;
	private V value;
	
	public void put(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public V get(K key) {
		return this.value;
	}
}

class MyModel {
	private Map<String, Object> attrs;
	
	public MyModel() {
		this.attrs = new HashMap<>();
	}
	
	public void addAttribute(String name, Object value) {
		attrs.put(name, value);
	}
	
	public Object getAttribute(String name) {
		return attrs.get(name);
	}
}

public class Review17Main {

	public static void main(String[] args) {
		Box<Integer> box1 = new Box<>();
		box1.add(10);
		System.out.println(box1.get());
		
		Dictionary<String, Integer> menu = new Dictionary<>();
		menu.put("볶음밥", 6000);
		System.out.println(menu.get("볶음밥"));
		
		// String을 key로 하고, List<String>를 value로 하는 Map
		// {남=["홍길동"], 여=["Abc", "Def"]}
		Map<String, List<String>> map = new HashMap<>();
		
		List<String> males = Arrays.asList("Aaa", "Bbb");
		System.out.println(males);
		map.put("남", males);
		
		List<String> females = Arrays.asList("aaa", "bbb", "ccc");
		map.put("여", females);
		
		System.out.println(map);
		
		// MyModel 클래스의 객체를 생성
		MyModel model = new MyModel();
		model.addAttribute("userId", 1);
		model.addAttribute("userPw", "abcd");
		
		int id = (Integer) model.getAttribute("userId");
		System.out.println(id);
		String pw = (String) model.getAttribute("userPw");
		System.out.println(pw);
	}

}
