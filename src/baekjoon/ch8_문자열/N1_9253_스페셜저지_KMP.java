package baekjoon.ch8_문자열;

/**
 *  "편의상 사용자가 출력한 문자열의 길이가 문제의 답과 동일하고, 답은 0보다 크다고 가정한다."
 * 라는 조건이 있으므로, 문자열 A, B에 사용자의 문자열이 포함되어 있는지만 확인하면 된다.
 *
 * 1. KMP
 * 2. Rolling Hash
 * **/

import java.io.*;

public class N1_9253_스페셜저지_KMP {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		String answer = br.readLine();
		int[] table = makeTable(answer);

		String result = "NO";
		if (KMP(A, answer, table) && KMP(B, answer, table)) {
			result = "YES";
		}
		System.out.println(result);
	}

	static int[] makeTable(String str) {
		int[] table = new int[str.length()];
		int idx = 0;
		for (int i = 1; i < table.length; i++) {
			while (idx > 0 && str.charAt(i) != str.charAt(idx)) {
				idx = table[idx - 1];
			}

			if (str.charAt(idx) == str.charAt(i)) {
				table[i] = ++idx;
			}
		}
		return table;
	}

	static boolean KMP (String parent, String target, int[] table) {
		int idx = 0;
		for (int i = 0; i < parent.length(); i++) {
			while (idx > 0 && parent.charAt(i) != target.charAt(idx)){
				idx = table[idx - 1];
			}
			if (parent.charAt(i) == target.charAt(idx)) {
				if (idx == target.length()-1) {
					return true;
				} else {
					idx++;
				}
			}
		}
		return false;
	}
}
