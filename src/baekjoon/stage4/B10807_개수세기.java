package baekjoon.stage4;

import java.io.*;

public class B10807_개수세기 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		String[] nums = br.readLine().split(" ");
		String target = br.readLine();

		int result = 0;
		for (String a : nums) {
			if (a.equals(target)) {
				result++;
			}
		}
		System.out.println(result);
	}
}
