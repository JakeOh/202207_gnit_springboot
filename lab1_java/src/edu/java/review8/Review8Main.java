package edu.java.review8;

public class Review8Main {

	public static void main(String[] args) {
		Book book1 = new Book("author", "title", "test");
		// 생성자 호출할 때 전달한 값들이 객체의 어떤 프로퍼티(필드)인 지 
		// 코드만 봐서는 이해하기 힘듦.
		System.out.println(book1);
		
		Book book2 = Book.builder()
				.author("author")
				.description("test")
				.title("title")
				.build();
		System.out.println(book2);
	}

}
