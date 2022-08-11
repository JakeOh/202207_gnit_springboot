package edu.java.review3;

public class Review3Main {

	public static void main(String[] args) {
		// switch-case 문
		// 해당 case 코드부터 break를 만날 때까지 실행.
		// switch에서 사용할 수 있는 변수는 정수, 문자(char), 문자열(String), enum 타입. 
		
		String day = "화";
		switch (day) {
		case "월":
			System.out.println("벌써 월요일...");
			break;
		case "화":
			System.out.println("저녁 수업...");
			break;
		case "수":
			System.out.println("아직 수요일...");
			break;
		default:
			System.out.println("재택...");
		}
		
		day = "sun";
		switch (day) {
		case "Mon":
		case "Tue":
		case "Wed":
		case "Thu":
		case "Fri":
			System.out.println("출근");
			break;
		case "Sat":
		case "Sun":
			System.out.println("휴일");
			break;
		default:
			System.out.println("???");
		}

		// enum을 사용한 switch-case 문
		Weekday wday = Weekday.TUE;
		switch (wday) {
		case MON:
		case TUE:
		case WED:
		case THU:
			System.out.println("근무");
			break;
		case FRI:
		case SAT:
		case SUN:
			System.out.println("휴식");
			break;
		default:
			System.out.println("???");
		}
		
	}

}
