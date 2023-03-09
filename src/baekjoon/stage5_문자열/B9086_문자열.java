package baekjoon.stage5_문자열;

import java.io.*;

/**
 * char -> int
 *
 * char c1 = '9';
 *
 * int i1 = c1 - '0'; // 57 - 48 = 9
 * Character.getNumericValue(c1) // 9
 * **/

public class B9086_문자열 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			System.out.println(str.charAt(0) + "" + str.charAt(str.length()-1));
		}
	}
}
