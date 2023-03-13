package baekjoon.stage8_기본수학1;

import java.math.BigDecimal;
import java.util.Scanner;

public class N6_10757_큰수AB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigDecimal num1 = new BigDecimal(sc.next());
		BigDecimal num2 = new BigDecimal(sc.next());

		System.out.println(num1.add(num2));
	}
}
