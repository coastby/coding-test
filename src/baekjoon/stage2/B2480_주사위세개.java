package baekjoon.stage2;

import java.util.*;
import java.io.*;

public class B2480_주사위세개 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		TreeSet<Integer> set = new TreeSet<Integer>(Arrays.asList(a, b, c));
		if (set.size() == 1) {
			System.out.println(10000 + set.first() * 1000);
		} else if (set.size() == 3) {
			System.out.println(set.last() * 100);
		} else {
			if (a == b || a == c) {
				System.out.println(1000 + a * 100);
			} else {
				System.out.println(1000 + b * 100);
			}
		}
	}
}
