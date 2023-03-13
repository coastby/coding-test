package baekjoon.stage7_2차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N3_10798_세로읽기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Character[][] chars = new Character[5][15];
		for (int i = 0; i < 5; i++) {
			String word = br.readLine();
			for (int j = 0; j < word.length(); j++) {
				chars[i][j] = word.charAt(j);
			}
		}
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if (chars[j][i] != null) {
					sb.append(chars[j][i]);
				}
			}
		}
		System.out.println(sb);
	}

}
