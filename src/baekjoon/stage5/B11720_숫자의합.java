package baekjoon.stage5;

import java.io.*;

public class B11720_숫자의합 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String num = br.readLine();
		int sum = 0;
		for (int i = 0; i < num.length(); i++) {
			sum += num.charAt(i) - '0';
		}
		System.out.println(sum);
	}
}
