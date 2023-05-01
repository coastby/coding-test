package baekjoon.ch10_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N8_7795_먹을것인가먹힐것인가 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] A = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[j] = Integer.parseInt(st.nextToken());
			}
			int[] B = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				B[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(A);
			Arrays.sort(B);
			int count = 0;
			int temp = 0;
			for (int j = 0; j < N; j++) {
				for (int k = temp; k < M; k++) {
					if(A[j] <= B[k]) {
						count += k;
						temp = k;
						break;
					}
					if (k == M-1) {
						count += M;
						temp = M - 1;
					}
				}
			}
			System.out.println(count);

		}
	}

}

/***
 * 1 1 3 7 8
 * 1 3 6
 * **/
