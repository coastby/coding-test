package baekjoon.stage1_IO;

import java.io.*;

public class B1000_plus {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nums = br.readLine().split(" ");
		int a = Integer.parseInt(nums[0]);
		int b = Integer.parseInt(nums[1]);
		System.out.println(a + b);

	}
}
