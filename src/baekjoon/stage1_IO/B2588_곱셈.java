package baekjoon.stage1_IO;

/**
 * substring()
 * **/

import java.io.*;


public class B2588_곱셈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int first = Integer.parseInt(br.readLine());
		String second = br.readLine();

		for (int i = 3; i > 0; i--) {
			System.out.println(Integer.parseInt(second.substring(i-1, i)) * first);
		}
		System.out.println(first * Integer.parseInt(second));
	}

}
