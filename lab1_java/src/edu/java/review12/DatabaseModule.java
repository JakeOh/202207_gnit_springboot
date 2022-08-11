package edu.java.review12;

public interface DatabaseModule {

	// interface에서 field 선언은 public static final을 생략.
	int DB_VERSION = 1;
	
	// interface에서 메서드 선언은 public abstract를 생략.
	
	/**
	 * DB insert 기능.
	 * 
	 * @param s insert할 문자열.
	 * @return DB 테이블에 insert된 행의 개수.
	 */
	int insert(String s);
	
	String select();
	
}
