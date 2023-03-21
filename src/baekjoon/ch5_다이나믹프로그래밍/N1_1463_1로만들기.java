package baekjoon.ch5_다이나믹프로그래밍;

import java.util.Scanner;

public class N1_1463_1로만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] dp = new int[N+3];
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		int n = 4;
		while (n <= N) {
			if (n % 3 == 0 && n % 2 == 0) {
				dp[n] = Math.min(dp[n/3], Math.min(dp[n/2], dp[n-1])) + 1;
			} else if (n % 3 == 0) {
				dp[n] = Math.min(dp[n/3], dp[n-1]) + 1;
			} else if (n % 2 == 0) {
				dp[n] = Math.min(dp[n/2], dp[n-1]) + 1;
			} else {
				dp[n] = dp[n-1] + 1;
			}
			n++;
		}
		System.out.println(dp[N]);
	}
}
