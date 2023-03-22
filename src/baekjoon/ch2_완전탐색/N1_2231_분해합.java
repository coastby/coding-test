package baekjoon.ch2_완전탐색;

import java.util.Scanner;

public class N1_2231_분해합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 1; i < N; i++) {
			int sum = i;
			String str = i+"";
			for (int j = 0; j < str.length(); j++) {
				sum += str.charAt(j) - '0';
			}
			if (sum == N) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}
}
