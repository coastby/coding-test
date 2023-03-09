package baekjoon.stage1_IO;

/**
 * 정수 / 정수 = 정수
 * 실수 / 실수 = 실수
 * **/

import java.io.*;

public class B1008_divide {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nums = br.readLine().split(" ");
		double a = Double.parseDouble(nums[0]);
		double b = Double.parseDouble(nums[1]);
		System.out.println(a / b);

	}
}
