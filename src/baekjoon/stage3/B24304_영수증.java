package baekjoon.stage3;

import java.io.*;
import java.util.*;

public class B24304_영수증 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = Integer.parseInt(br.readLine());
		int total = Integer.parseInt(br.readLine());
		int result = 0;
		for (int i = 0; i < total; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int price = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			result += price * num;
		}
		if (sum == result) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
