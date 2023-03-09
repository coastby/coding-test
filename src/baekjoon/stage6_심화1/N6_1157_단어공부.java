package baekjoon.stage6_심화1;

import java.io.*;
import java.util.HashMap;

public class N6_1157_단어공부 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toUpperCase();
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch)+1);
			} else {
				map.put(ch, 1);
			}
		}
		int max = 0;
		char result = '?';
		for (char ch : map.keySet()) {
			int cnt = map.get(ch);
			if (max < cnt) {
				max = cnt;
				result = ch;
			} else if (max == cnt) {
				result = '?';
			}
		}
		System.out.println(result);
	}
}
