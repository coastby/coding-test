package baekjoon.ch2_완전탐색;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N8_2615_오목 {
	static int[][] omok = new int[21][21];
	static int[] dr = {0, 1, -1, 1};
	static int[] dc = {1, 1, 1, 0};
	static int result = 0;
	static int now;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 1; i < 20; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 20; j++) {
				omok[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				now = omok[i][j];
				if (now == 0) {
					continue;
				}
				for (int k = 0; k < 4; k++) {
					search(0, i, j, k);
				}
				if (result != 0) {
					System.out.println(result);
					System.out.println(i + " " + j);
					return;
				}
			}
		}
		System.out.println(0);
	}

	static void search(int depth, int r, int c, int direction) {
		if (omok[r][c] != now) {
			return;
		}
		if (depth == 4) {
			if (omok[r-5*dr[direction]][c-5*dc[direction]] == now) return;
			result = now;
		}
		if (depth == 5 && omok[r][c] == now) {
			result = 0;
			return;
		}
		//0 : 가로, 1 : 대각선 \, 2: 대각선 /, 3 : 세로
		search(depth + 1, r + dr[direction], c + dc[direction], direction);
	}

}
