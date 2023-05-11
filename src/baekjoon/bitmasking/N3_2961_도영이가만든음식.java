package baekjoon.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N3_2961_도영이가만든음식 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] taste = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			taste[i][0] = Integer.parseInt(st.nextToken());
			taste[i][1] = Integer.parseInt(st.nextToken());
		}
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < 1 << N; i++) {
			int sour = 1;
			int bitter = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1<<j)) != 0) {
					sour *= taste[j][0];
					bitter += taste[j][1];
				}
			}
			min = Math.min(min, Math.abs(sour-bitter));
		}

		System.out.println(min);
	}

}
