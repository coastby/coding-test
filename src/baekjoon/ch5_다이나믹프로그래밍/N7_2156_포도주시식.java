package baekjoon.ch5_다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N7_2156_포도주시식 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] wines = new int[n + 2];
		for (int i = 1; i <= n; i++) {
			wines[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[n + 2];
		dp[1] = wines[1];
		dp[2] = dp[1] + wines[2];
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(wines[i-1] + dp[i-3], dp[i - 2]) + wines[i];
			dp[i] = Math.max(dp[i - 1], dp[i]);		//포도주를 먹지 않는 것도 선택이 될 수 있다.
		}
		System.out.println(dp[n]);
	}

}
