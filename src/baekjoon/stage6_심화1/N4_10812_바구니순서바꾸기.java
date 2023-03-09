package baekjoon.stage6_심화1;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class N4_10812_바구니순서바꾸기 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] basket = IntStream.rangeClosed(0, N).toArray();
		for (int n = 0; n < M; n++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[] tmp = basket.clone();
			for (int m = 0; m < j-i+1; m++) {
				if (k+m > j) {
					basket[i+m] = tmp[i+(k+m)-j-1];
				} else {
					basket[i+m] = tmp[k+m];
				}
			}
		}
		for (int i = 1; i < N+1; i++) {
			System.out.print(basket[i] + " ");
		}
	}
}
