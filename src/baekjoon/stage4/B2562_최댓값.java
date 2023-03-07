package baekjoon.stage4;

import java.util.*;

public class B2562_최댓값 {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int idx = 0;
		for (int i = 0; i < 9; i++) {
			int n = sc.nextInt();
			if (n > max) {
				max = n;
				idx = i + 1;
			}
		}
		System.out.println(max);
		System.out.println(idx);
	}

}
