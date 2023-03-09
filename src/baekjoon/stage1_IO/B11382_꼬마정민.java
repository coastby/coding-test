package baekjoon.stage1_IO;

import java.io.*;

public class B11382_꼬마정민 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nums = br.readLine().split(" ");

		long sum = 0;
		for (String str : nums) {
			sum += Long.parseLong(str);
		}
		System.out.println(sum);
	}
}
