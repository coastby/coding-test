package baekjoon.ch2_완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2_10448_유레카이론 {

	static int[] T = new int[50];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		makeT();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			int max = Math.min(num, 50);
			isEureka(num, max);
		}
	}

	static void makeT () {
		for (int i = 0; i < 50; i++) {
			T[i] = i * (i+1)/2;
		}
	}

	static void isEureka(int num, int max) {
		for (int j = 1; j < max; j++) {
			for (int k = 1; k < max; k++) {
				for (int l = 1; l < max; l++) {
					int sum = T[j] + T[k] + T[l];
					if (sum == num) {
						System.out.println(1);
						return;
					} else if (sum > num) {
						break;
					}
				}
			}
		}
		System.out.println(0);
	}
}
