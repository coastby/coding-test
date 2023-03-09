package baekjoon.stage4_1차원배열;

import java.io.*;
import java.util.*;

public class B10813_공바꾸기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] basket = new int[N];
		for (int i = 1; i < N+1; i++) {
			basket[i-1] = i;
		}
		for (int n = 0; n < M; n++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;
			int tmp = basket[i];
			basket[i] = basket[j];
			basket[j] = tmp;
		}
		for (int n : basket) {
			System.out.print(n + " ");
		}
	}
}
