package edu.java.review12;

interface Buyer {
	// public abstract 메서드
	void buy();
	
	// public body를 갖는(default) 메서드
	default void order() {
		System.out.println("구매자 주문.");
	}
}

interface Seller {
	void sell();
	
	default void order() {
		System.out.println("판매자 주문.");
	}
}

public class Customer implements Buyer, Seller {

	@Override
	public void sell() {
		System.out.println("판매");
	}

	@Override
	public void buy() {
		System.out.println("구매");
	}

	// 다중 상속의 문제를 해결하기 위한 override
	@Override
	public void order() {
		// Buyer super 타입의 order (default) 메서드를 호출
		Buyer.super.order();
		// Seller super 타입의 order (default) 메서드를 호출
		Seller.super.order();
		System.out.println("고객 주문.");
	}

}
