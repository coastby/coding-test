package baekjoon.stage4;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class B10811_바구니뒤집기 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] basket = IntStream.rangeClosed(1, N).toArray();


		for (int n = 0; n < M; n++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			int[] tmp = Arrays.copyOfRange(basket, i-1, j);

			// tmp 마지막 인덱스 : j-i
			// tmp 인덱스 : j-i, j-i-1, j-i-2, ... 0
			// m : i-1, i, i+1, ... j-1

			for (int m = i-1; m < j; m++) {
				basket[m] = tmp[j-m-1];
			}
		}
		for (int a : basket) {
			System.out.print(a + " ");
		}
	}
}
