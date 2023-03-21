package baekjoon.ch5_다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2_2579_계단오르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] steps = new int[N + 2];
		for (int i = 1; i <= N; i++) {
			steps[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[N + 2];
		dp[1] = steps[1];
		dp[2] = dp[1] + steps[2];
		dp[3] = Math.max(steps[1], steps[2]) + steps[3];
		for (int i = 4; i <= N; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3]+steps[i-1]) + steps[i];
		}
		System.out.println(dp[N]);
	}

}
