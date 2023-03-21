package baekjoon.ch4_그리디;

import java.util.Scanner;

public class N3_14916_거스름돈 {
	static int INF = (int) 1e9;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] dp = new int[n + 5];
		dp[0] = INF;
		dp[1] = INF;
		dp[2] = 1;
		dp[3] = INF;
		dp[4] = 2;
		dp[5] = 1;
		for (int i = 6; i <= n; i++) {
			dp[i] = Math.min(dp[i-5], dp[i-2]) + 1;
		}
		if (dp[n] >= INF) {
			System.out.println(-1);
			return;
		}
		System.out.println(dp[n]);
	}
}
