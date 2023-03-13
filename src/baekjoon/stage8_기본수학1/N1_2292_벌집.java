package baekjoon.stage8_기본수학1;

import java.util.Scanner;

/***
 * 1 -> +6 -> +12 -> +18
 * **/

public class N1_2292_벌집 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int result = 0;
		int max = 1;
		while (true) {
			max += result * 6;
			if (N <= max) {
				System.out.println(result+1);
				break;
			} else {
				result++;
			}
		}
	}

}
