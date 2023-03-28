package baekjoon.ch8_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2_9046_복호화 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int[] alph = new int[26];
			String pw = br.readLine();
			pw = pw.replace(" ", "");
			for (int j = 0; j < pw.length(); j++) {
				int idx = pw.charAt(j) - 'a';
				alph[idx] = alph[idx] + 1;
			}
			int max = 0;
			int idx = -1;
			for (int j = 0; j < 26; j++) {
				if (alph[j] > max) {
					max = alph[j];
					idx = j;
				} else if (alph[j] == max) {
					idx = -1;
				}
			}
			if (idx == -1) {
				System.out.println("?");
				continue;
			}
			System.out.println((char) (idx + 'a'));
		}
	}
}
