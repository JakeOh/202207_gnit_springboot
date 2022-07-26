package edu.java.review8;

public class Book {
	// field
	private String title;
	private String author;
	private String description;
	
	// 마우스 오른쪽 클릭 -> Source -> Generate constructor using fields
	// 생성자(constructor)
	public Book(String title, String author, String description) {
		this.title = title;
		this.author = author;
		this.description = description;
	}

	// 메서드
	public String toString() {
		// 문자열 템플릿에서 사용되는 기호:
		// %s: 문자열, %d: 정수, %f: 실수
		return String.format("Book(title=%s, author=%s, description=%s)",
				this.title, this.author, this.description);
	}
	
	// Builder(Factory) 디자인 패턴:
	// static 내부 클래스(inner class)
	public static class BookBuilder {
		private String title;
		private String author;
		private String description;
		
		private BookBuilder() {}  // private 생성자
		
		public BookBuilder title(String title) {
			this.title = title;
			return this;
		}
		
		public BookBuilder author(String author) {
			this.author = author;
			return this;
		}
		
		public BookBuilder description(String description) {
			this.description = description;
			return this;
		}
		
		public Book build() {
			return new Book(this.title, this.author, this.description);
		}
	}  // end class BookBuilder
	
	public static BookBuilder builder() {
		return new BookBuilder();
	}
	
}  // end class Book
