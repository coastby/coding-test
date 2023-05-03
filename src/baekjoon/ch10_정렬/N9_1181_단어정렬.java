package baekjoon.ch10_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N9_1181_단어정렬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		StringBuilder sb = new StringBuilder();
		Arrays.stream(words).distinct().sorted((w1, w2) -> {
			if (w1.length() != w2.length()) {
				return w1.length() - w2.length();
			} else {
				return w1.compareTo(w2);
			}
		}).forEach(w -> sb.append(w).append("\n"));

		System.out.println(sb);
	}

}
