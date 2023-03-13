package baekjoon.stage7_2차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2_2566_최댓값 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int max = 0;
		int row = 1;
		int col = 1;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				int now = Integer.parseInt(st.nextToken());
				if (now > max) {
					max = now;
					row = i+1;
					col = j+1;
				}
			}
		}
		System.out.println(max);
		System.out.println(row + " " + col);
	}

}
