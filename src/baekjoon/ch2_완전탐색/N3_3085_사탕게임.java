package baekjoon.ch2_완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N3_3085_사탕게임 {
	static char[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new char[N][N];
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = row.charAt(j);
			}
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				char a = board[i][j];
				if (i != N-1) {
					char down = board[i+1][j];
					if (a != down) {
						board[i+1][j] = a;
						board[i][j] = down;
						int m = Math.max(max(a), max(down));
						board[i+1][j] = down;
						board[i][j] = a;
						max = Math.max(m, max);
					}
				}
				if (j != N-1) {
					char right = board[i][j+1];
					if (a != right) {
						board[i][j+1] = a;
						board[i][j] = right;
						int n = Math.max(max(a), max(right));
						board[i][j+1] = right;
						board[i][j] = a;
						max = Math.max(n, max);
					}
				}
			}
		}
		int[] maxes = {max, max('C'), max('Y'), max('Z'), max('P')};
		Arrays.sort(maxes);
		System.out.println(maxes[4]);
	}

	static int max(char ch) {
		int max = 0;
		for (int i = 0; i < board.length; i++) {
			int rowMax = 0;
			int cntX = 0;
			for (int j = 0; j < board.length; j++) {	//가로 찾기
				if (board[i][j] == ch) {
					cntX++;
				} else {
					rowMax = Math.max(rowMax, cntX);
					cntX = 0;
				}
			}
			rowMax = Math.max(rowMax, cntX);
			max = Math.max(max, rowMax);
			int colMax = 0;
			int cntY = 0;
			for (int j = 0; j < board.length; j++) {	//세로 찾기
				if (board[j][i] == ch) {
					cntY++;
				} else {
					colMax = Math.max(colMax, cntY);
					cntY = 0;
				}
			}
			colMax = Math.max(colMax, cntY);
			max = Math.max(max, colMax);
		}
		return max;
	}

}
