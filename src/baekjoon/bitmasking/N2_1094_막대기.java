package baekjoon.bitmasking;

import java.util.Scanner;

/**
 * 		System.out.println(Integer.bitCount(X));
 * **/

public class N2_1094_막대기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int count = 0;
		for (int i = 0; i <= 6; i++) {
			if ((X & (1 << i)) != 0) {
				count++;
			}
		}
		System.out.println(count);
	}
}
