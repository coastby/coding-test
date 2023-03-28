package baekjoon.ch8_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N3_16171_나는친구가적다 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String K = br.readLine();

		for (int i = 0; i <= 10; i++) {
			S = S.replace(i+"", "");
		}
		int result = 0;
		if (S.contains(K)) {
			result = 1;
		}
		System.out.println(result);
	}
}
