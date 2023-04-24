package baekjoon.ch3_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N5_1920_수찾기 {
	static int N;
	static int[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);

		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			sb.append(exist(target)).append("\n");
		}
		System.out.println(sb);
	}

	static int exist(int target) {
		int start = 0;
		int end = N-1;
		while (start <= end) {
			int m = (start + end) / 2;
			if (A[m] == target) {
				return 1;
			} else if (A[m] > target) {
				end = m -1;
			} else {
				start = m + 1;
			}
		}
		return 0;
	}

}
