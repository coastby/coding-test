package baekjoon.ch6_재귀_분할정복_백트래킹;

import java.io.*;
import java.util.*;

public class N6_15649_N과M1 {
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	static int[] arr;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		boolean[] check = new boolean[N+1];
		arr = new int[M];
		print(M, check);
		System.out.println(sb);
	}

	static void print(int depth, boolean[] check) {
		if (depth == 0) {
			Arrays.stream(arr).forEach(num -> sb.append(num).append(" "));
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (!check[i]) {
				check[i] = true;
				arr[M-depth] = i;
				print(--depth, check);
				depth++;
				check[i] = false;
			}

		}
	}

}
