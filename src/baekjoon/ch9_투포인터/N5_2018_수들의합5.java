package baekjoon.ch9_투포인터;

import java.util.Scanner;

public class N5_2018_수들의합5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int cnt = 1;
		if (N != 1 && N != 2) {
			for (int i = 1; i <= N/2 + 1; i++) {
				int sum = 0;
				for (int j = i; j <= N; j++) {
					sum += j;
					if (sum == N) {
						cnt++;
						break;
					} else if (sum > N) {
						break;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
