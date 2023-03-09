package baekjoon.stage4_1차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10818_최소최대 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		String[] nums = br.readLine().split(" ");

		int min = 1000000;
		int max = -1000000;
		for (String a : nums) {
			int x = Integer.parseInt(a);
			min = Math.min(x, min);
			max = Math.max(x, max);
		}
		System.out.println(min + " " + max);
	}
}
