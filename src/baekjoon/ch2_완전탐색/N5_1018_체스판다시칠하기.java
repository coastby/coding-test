package baekjoon.ch2_완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N5_1018_체스판다시칠하기 {
	static char[][] sample;
	static char[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		board = new char[N][M];		//입력
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j);
			}
		}

		sample = new char[8][8];		//init
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i - j) % 2 == 0) {
					sample[i][j] = 'W';
				} else {
					sample[i][j] = 'B';
				}
			}
		}

		int min = 64;
		for (int i = 0; i <= N - 8; i++) {		//시작 포인트 (i, j)
			for (int j = 0; j <= M - 8; j++) {
				min = Math.min(min, change(i, j));
			}
		}
		System.out.println(min);
	}

	static int change(int r, int c) {
		int count = 0;
		for (int i = r; i < r + 8; i++) {
			for (int j = c; j < c + 8; j++) {
				if (board[i][j] != sample[i - r][j - c]) {
					count++;
				}
			}
		}
		return Math.min(count, 64 - count);
	}

}
