package baekjoon.stage4_1차원배열;

import java.util.*;

public class B3052_나머지 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] namuji = new boolean[42];

		for (int i = 0; i < 10; i++) {
			int num = sc.nextInt() % 42;
			namuji[num] = true;
		}
		int result = 0;
		for (int i = 0; i < 42; i++) {
			if(namuji[i]) {
				result++;
			}
		}
		System.out.println(result);
	}
}

/**
 * Set 이용
 * 		Scanner s = new Scanner(System.in);
 * 		HashSet<Integer> set = new HashSet<>();
 *
 * 		for(int i = 0; i < 10; i++ ) {
 * 			set.add(s.nextInt() % 42);
 *                }
 *
 * 		System.out.println(set.size());
 * **/
