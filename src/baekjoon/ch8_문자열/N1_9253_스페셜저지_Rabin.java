package baekjoon.ch8_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1_9253_스페셜저지_Rabin {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();
		String answer = br.readLine();

		String result = "NO";
		if (rabin(A, answer) && rabin(B, answer)) {
			result = "YES";
		}
		System.out.println(result);
	}

	static boolean rabin (String parent, String target) {
		boolean result;
		int tLen = target.length();
		int power = 1;
		int tHash = 0;
		int pHash = 0;

		for (int i = 1; i < tLen; i++) {
			tHash += power * target.charAt(tLen - i);
			pHash += power * parent.charAt(tLen - i);
			power *= 2;
		}

		tHash += power * target.charAt(0);
		pHash += power * parent.charAt(0);

		for (int i = 0; i <= parent.length() - tLen; i++) {
			if (i > 0) {
				pHash -= power * parent.charAt(i-1);
				pHash = pHash * 2 + parent.charAt(i + tLen - 1);
			}
			if (tHash == pHash) {
				result = true;
				for (int j = 0; j < tLen; j++) {
					if (parent.charAt(i + j) != target.charAt(j)) {
						result = false;
						break;
					}
				}
				if (result) return true;
			}
		}
		return false;
	}
}
