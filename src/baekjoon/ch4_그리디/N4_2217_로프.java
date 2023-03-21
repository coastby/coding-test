package baekjoon.ch4_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N4_2217_로프 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] rope = new int[N];
		for (int i = 0; i < N; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(rope);

		long max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, (long) i * rope[N-i]);
		}
		System.out.println(max);
	}
}
