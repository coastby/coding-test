package baekjoon.stage9_약수배수소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1_5086_배수와약수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			if (A == 0) {
				break;
			} else if (A % B == 0) {
				System.out.println("multiple");
			} else if (B % A == 0) {
				System.out.println("factor");
			} else {
				System.out.println("neither");
			}
		}
	}
}
