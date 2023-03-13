package baekjoon.stage6_심화1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9_1316_그룹단어체커 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int count = 0;
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			boolean[] memo = new boolean[26];
			char pre = '?';
			for (int j = 0; j < word.length(); j++) {
				char ch = word.charAt(j);
				if (pre != ch && memo[ch-'a']) {
					break;
				} else if (j == word.length()-1){
					count++;
				} else if (!memo[ch-'a']) {
					memo[ch-'a'] = true;
					pre = ch;
				}
			}
		}
		System.out.println(count);
	}
}
