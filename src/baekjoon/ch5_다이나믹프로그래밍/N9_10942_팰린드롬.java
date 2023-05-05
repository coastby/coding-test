package baekjoon.ch5_다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N9_10942_팰린드롬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		boolean[][] dp = new boolean[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			dp[i][i] = true;		//대각선 \ 채우기
			if (i != N) {			// 한 칸 앞 채우기
				dp[i][i+1] = nums[i] == nums[i+1];
			}
		}

		for (int i = 2; i < N; i++) {
			for (int j = 1; j <= N-i; j++) {
				if (nums[j] == nums[j+i]) {
					dp[j][j+i] = dp[j+1][j+i-1];
				}
			}
		}

		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			if (dp[S][E]) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}
}
