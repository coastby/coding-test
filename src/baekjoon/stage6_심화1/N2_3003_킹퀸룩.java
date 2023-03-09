package baekjoon.stage6_심화1;

import java.util.*;

public class N2_3003_킹퀸룩 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] chess = {1, 1, 2, 2, 2, 8};
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 6; i++) {
			int r = sc.nextInt();
			sb.append(chess[i] - r).append(" ");
		}
		System.out.println(sb);
	}
}
