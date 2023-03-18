package baekjoon.ch1_구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1_2578_빙고 {
	static boolean[][] bingo = new boolean[5][5];
	static int[][] loc = new int[26][2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 5; i++) {		//빙고판 채우기
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				loc[num][0] = i;
				loc[num][1] = j;
			}
		}

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int call = Integer.parseInt(st.nextToken());
				bingo[loc[call][0]][loc[call][1]] = true;
				if (line() >= 3) {
					System.out.println(5*i + j + 1);
					return;
				}
			}
		}
	}

	static int line() {
		int cnt = 0;
		boolean d1 = true;
		boolean d2 = true;
		for (int i = 0; i < 5; i++) {
			boolean horizontal = true;
			boolean vertical = true;

			for (int j = 0; j < 5; j++) {
				if (!bingo[i][j]) {
					horizontal = false;
				}
				if (!bingo[j][i]) {
					vertical = false;
				}
			}
			if (!bingo[i][4-i]) {
				d1 = false;
			}
			if (!bingo[i][i]) {
				d2 = false;
			}
			if (horizontal) {cnt++;}
			if (vertical) {cnt++;}
		}
		if (d1) {cnt++;}
		if (d2) {cnt++;}
		return cnt;
	}

}
