package programmers.level3;

import java.util.*;

class 다단계칫솔판매 {
	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		Map<String, Seller> sellerMap = new HashMap<>();
		for (int i = 0; i < enroll.length; i++) {
			sellerMap.put(enroll[i], new Seller(enroll[i]));
		}
		for (int i = 0; i < enroll.length; i++) {
			sellerMap.get(enroll[i]).setReferral(sellerMap.get(referral[i]));
		}
		for (int i = 0; i < seller.length; i++) {
			sellerMap.get(seller[i]).profit(amount[i] * 100);
		}
		int[] answer = new int[enroll.length];
		for (int i = 0; i < enroll.length; i++) {
			answer[i] = sellerMap.get(enroll[i]).getTotal();
		}
		return answer;
	}
}

class Seller {
	String name;
	Seller referral;
	int total;

	public Seller (String name) {
		this.name = name;
	}

	void setReferral(Seller referral) {
		this.referral = referral;
	}

	void plusTotal (int amount) {
		total += amount;
	}

	int getTotal() {
		return this.total;
	}

	void profit(int sales) {
		int per = (int) Math.floor(sales / 10.0);
		plusTotal(sales - per);
		if (this.referral != null && per != 0) {
			this.referral.profit(per);
		}
	}

	@Override
	public String toString() {
		return "[" + this.name +" : " +this.total+ "]";
	}
}
