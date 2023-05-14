package baekjoon.ch8_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class N9_4659_비밀번호발음하기 {
	static List<Character> moeum = List.of('a', 'e', 'i', 'o', 'u');

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String pw = br.readLine();
			if (pw.equals("end")) {
				break;
			}
			if (check(pw)) {
				sb.append(String.format("<%s> is acceptable.\n", pw));
			} else {
				sb.append(String.format("<%s> is not acceptable.\n", pw));
			}
		}
		System.out.println(sb);
	}

	static boolean check(String pw) {
		int jc = 0;
		int mc = 0;
		int m = 0;
		char pre = 'a' - 1;
		for (int i = 0; i < pw.length(); i++) {
			char ch = pw.charAt(i);
			if (pre == ch && (ch != 'e' && ch != 'o')) return false;
			if (moeum.contains(ch)) {
				m++;
				mc++;
				jc = 0;
			} else {
				mc = 0;
				jc++;
			}
			pre = ch;
			if (jc >= 3 || mc >= 3) return false;
		}
		return m != 0;
	}

}
