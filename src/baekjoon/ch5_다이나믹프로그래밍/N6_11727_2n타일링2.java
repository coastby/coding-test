package baekjoon.ch5_다이나믹프로그래밍;

import java.util.Scanner;

public class N6_11727_2n타일링2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] dp = new int[n + 2];
		dp[1] = 1;
		dp[2] = 3;

		for (int i = 3; i <= n; i++) {
			dp[i] = (2 * dp[i - 2] + dp[i - 1]) % 10007;
		}
		System.out.println(dp[n]);
	}
}
