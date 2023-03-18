package baekjoon.stage10_시간복잡도;

import java.util.Scanner;

public class N7_24313_알고리즘수업 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a1 = sc.nextInt();
		int a0 = sc.nextInt();
		int c = sc.nextInt();
		int n0 = sc.nextInt();
		int fn = f(a1, a0, n0);
		if (a1 <= c && fn <= c*n0) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
	static int f(int a1, int a0, int n) {
		return a1*n+a0;
	}

}
