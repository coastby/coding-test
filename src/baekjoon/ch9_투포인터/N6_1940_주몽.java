package baekjoon.ch9_투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N6_1940_주몽 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] materials = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			materials[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(materials);
		int count = 0;
		int tempJ = N-1;
		for (int i = 0; i < N-1; i++) {
			int a = materials[i];
			if (a >= M) {
				break;
			}
			for (int j = tempJ; j > i; j--) {
				int b = materials[j];
				if (a + b == M) {
					count++;
					tempJ = j - 1;
					break;
				} else if (a + b < M) {
					tempJ = j;
					break;
				}
			}
		}
		System.out.println(count);
	}
}
