package baekjoon.stage9_약수배수소수;

import java.util.Scanner;

public class N6_11653_소인수분해 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();

		for (int i = 2; i <= N; i++) {
			if (N == 1) {break;}
			while (N % i == 0) {
				sb.append(i + "\n");
				N /= i;
			}
		}
		System.out.println(sb);
	}
}
