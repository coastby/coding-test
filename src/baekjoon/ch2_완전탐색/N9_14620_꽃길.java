package baekjoon.ch2_완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N9_14620_꽃길 {
	static int N;
	static int[][] costs;
	static boolean[][] flower;
	static int min = 200 * 5 * 3;
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		costs = new int[N][N];
		flower = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				costs[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		getMinCost(0, 0, 1);
		System.out.println(min);
	}

	static void getMinCost(int depth, int sum, int nr) {
		if (depth == 3) {
			min = Math.min(min, sum);
			return;
		}

		for (int i = nr; i < N-1; i++) {
			for (int j = 1; j < N-1; j++) {
				int plus = 0;
				boolean able = true;
				for (int k = 0; k < 5; k++) {
					if (flower[i+dx[k]][j+dy[k]]) able = false;
					plus += costs[i+dx[k]][j+dy[k]];
				}
				if (able) {
					for (int k = 0; k < 5; k++) {
						flower[i+dx[k]][j+dy[k]] = true;
					}
					getMinCost(depth + 1, sum + plus, i);
					for (int k = 0; k < 5; k++) {
						flower[i+dx[k]][j+dy[k]] = false;
					}
				}
			}
		}
	}
}
