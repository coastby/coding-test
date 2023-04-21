package baekjoon.ch5_다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N4_1149_RGB거리 {
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		dp = new int[N + 1][3];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			dp[1][i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 2; i <= N; i++) {
			fill(i, br.readLine());
		}

		System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));

	}

	static void fill(int i, String line) {
		StringTokenizer st = new StringTokenizer(line);
		for (int j = 0; j < 3; j++) {		//i의 색
			int value = Integer.parseInt(st.nextToken());
			switch (j) {
				case 0:
					dp[i][j] = Math.min(dp[i-1][1], dp[i-1][2]) + value;
					break;
				case 1:
					dp[i][j] = Math.min(dp[i-1][0], dp[i-1][2]) + value;
					break;
				case 2:
					dp[i][j] = Math.min(dp[i-1][1], dp[i-1][0]) + value;
					break;
			}
		}
	}

}
