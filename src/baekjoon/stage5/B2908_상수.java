package baekjoon.stage5;

import java.io.*;
import java.util.*;

public class B2908_상수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb;
		sb = new StringBuilder(st.nextToken());
		int a = Integer.parseInt(sb.reverse().toString());
		sb = new StringBuilder(st.nextToken());
		int b = Integer.parseInt(sb.reverse().toString());

		System.out.println(Math.max(a, b));
	}

}
