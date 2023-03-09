package baekjoon.stage5_문자열;

import java.io.*;
import java.util.*;

public class B2675_문자열반복 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			for (int j = 0; j < str.length(); j++) {
				String repeated = Character.toString(str.charAt(j)).repeat(R);
				sb.append(repeated);
			}
			System.out.println(sb.toString());
		}
	}
}
