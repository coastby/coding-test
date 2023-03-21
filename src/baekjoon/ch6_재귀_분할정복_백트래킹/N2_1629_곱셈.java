package baekjoon.ch6_재귀_분할정복_백트래킹;

/**
 * 묘듈러 연산
 * 	(A+B) %C
 *  = (A%C + B%C)%C
 *
 *  (A*B)%C
 *  = (A%C * B%C)%C
 * **/

import java.util.Scanner;

public class N2_1629_곱셈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		long C = sc.nextLong();

		System.out.println(modular(A, B, C));
	}

	static long modular (long a, long b, long c) {
		if (b == 1) {
			return a % c;
		}

		long tmp = modular(a, b/2, c);

		if (b % 2 == 0) {
			return (tmp * tmp) % c;
		} else {
			return (tmp * modular(a, b/2+1, c)) % c;
		}
	}
}
