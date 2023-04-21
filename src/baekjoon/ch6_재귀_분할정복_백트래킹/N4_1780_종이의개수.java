package baekjoon.ch6_재귀_분할정복_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N4_1780_종이의개수 {
	static int N;
	static int[][] paper;
	static int[] cnt = new int[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		count(N, 0, 0);
		System.out.println(cnt[0] + "\n" + cnt[1] + "\n" + cnt[2]);
	}

	static int count(int depth, int r, int c){
		if (depth == 1) {
			cnt[paper[r][c] + 1]++;
			return paper[r][c];
		}

		boolean clean = true;
		int type = paper[r][c];
		for (int i = 0; i < 3; i++) {		//가로
			for (int j = 0; j < 3; j++) {	//세로
				int piece = count(depth/3, r + i*depth/3, c + j*depth/3);
				if (piece != type || piece == 2) {
					clean = false;
				}
			}
		}

		if (clean) {
			cnt[type+1] = cnt[type+1] - 8;
			return type;
		} else {
			return 2;
		}
	}

}
