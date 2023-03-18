package baekjoon.stage9_약수배수소수;

import java.util.Scanner;

public class N5_2581_소수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();

		boolean[] isNotOnly = isNotOnly(N);
		int min = 0;
		int sum = 0;
		for (int i = M; i <= N; i++) {
			if (!isNotOnly[i]) {
				if (min == 0) {
					min = i;
				}
				sum += i;
			}
		}
		if (min == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

	static boolean[] isNotOnly(int N) {
		boolean[] memo = new boolean[N+1];
		memo[0] = true;
		memo[1] = true;
		for (int i = 2; i*i <= N; i++) {
			if (!memo[i]) {
				for (int j = 2; j <= N/i; j++) {
					memo[i*j] = true;
				}
			}
		}
		return memo;
	}

}
