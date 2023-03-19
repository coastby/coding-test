package baekjoon.ch1_구현;

import java.util.Arrays;
import java.util.Scanner;

public class N3_14501_퇴사 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] T = new int[N];
		int[] P = new int[N];
		for (int i = 0; i < N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}

		int[] total = new int[N+1];
		total[N] = 0;

		for (int i = N-1; i >= 0; i--) {
			if (i+T[i] > N) {
				total[i] = total[i+1];
				continue;
			}
			int book = P[i] + total[i+T[i]];
			total[i] = Math.max(book, total[i + 1]);
			System.out.println(Arrays.toString(total));
		}
		System.out.println(total[0]);
	}
}
