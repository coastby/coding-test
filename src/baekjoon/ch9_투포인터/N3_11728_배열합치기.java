package baekjoon.ch9_투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class N3_11728_배열합치기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int pa = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int now = Integer.parseInt(st.nextToken());
			while (pa < N && A[pa] <= now) {
				sb.append(A[pa++]).append(" ");
			}
			sb.append(now).append(" ");
		}
		while (pa < N) {
			sb.append(A[pa++]).append(" ");
		}
		System.out.println(sb);

	}

}
