package baekjoon.ch5_다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N5_11053_가장긴증가하는부분수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (A[i] > A[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[N-1]);
	}
}
