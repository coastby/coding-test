package baekjoon.stage8_기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 	1 4 10
 * 	1 3 6
 * 	1 2 3 4 5 6 ... i
 * **/

public class N5_2775_부녀회장이될테야 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int[][] apt = new int[16][16];
		for (int j = 0; j < 16; j++) {
	 		for (int l = 1; l < 16; l++) {
				if (j == 0) {
					apt[j][l] = l;
				} else {
					apt[j][l] = apt[j-1][l] + apt[j][l-1];
				}
			}
		}

		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());

			System.out.println(apt[k][n]);
		}
	}
}
