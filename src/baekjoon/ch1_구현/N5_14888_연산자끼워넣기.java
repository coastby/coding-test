package baekjoon.ch1_구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * + - x /
 * 음수를 양수로 나눌 때는 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꾼다.
 * **/


public class N5_14888_연산자끼워넣기 {
	static int N;
	static int[] A;
	static int[] Y;
	static int min = (int) 1e9;
	static int max = (int) -1e9;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		A = new int[N];		// 수열
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Y = new int[4];		// 연산자 +, -, x, /
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			Y[i] = Integer.parseInt(st.nextToken());
		}

		dfs(1, A[0]);
		System.out.println(max);
		System.out.println(min);

	}

	static void dfs(int depth, int pre) {
		if (depth == N) {
			min = Math.min(min, pre);
			max = Math.max(max, pre);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int next = Y[i];
			if (next != 0) {
				Y[i] = next-1;
				int calculated = calc(i, pre, A[depth]);
				dfs(depth + 1, calculated);
				Y[i] = next;
			}
		}
	}

	static int calc(int y, int a, int b) {
		switch (y) {
			case 0:
				return a + b;
			case 1:
				return a - b;
			case 2:
				return a * b;
			case 3:
				return a / b;
			default:
				return a;
		}
	}
}
