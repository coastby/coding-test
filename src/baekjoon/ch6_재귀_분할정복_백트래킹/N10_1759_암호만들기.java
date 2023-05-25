package baekjoon.ch6_재귀_분할정복_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class N10_1759_암호만들기 {
	static int L;
	static int C;
	static List<String> result = new ArrayList<>();
	static char[] alps;
	static List<Character> moem = List.of('a', 'e', 'i', 'o', 'u');

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		alps = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alps[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alps);
		makeWord(0, 0, 0, 0, new char[L]);
		StringBuilder sb = new StringBuilder();
		result.forEach(w -> sb.append(w).append("\n"));
		System.out.println(sb);
	}

	static void makeWord(int depth, int m, int j, int s, char[] word) {
		if (depth == L) {
			if(m > 0 && j > 1) {
				result.add(new String(word));
			}
			return;
		}

		for (int i = s; i < C; i++) {
			word[depth] = alps[i];
			if (moem.contains(alps[i])) {
				makeWord(depth + 1, m + 1, j, i  + 1, word);
			} else {
				makeWord(depth + 1, m, j+1, i + 1, word);
			}
		}
	}

}
