package baekjoon.ch4_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N6_1449_수리공항승 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] leakages = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			leakages[i] = Integer.parseInt(st.nextToken());

		}
		Arrays.sort(leakages);
		int count = 1;
		int start = leakages[0];
		for (int i = 1; i < N; i++) {
			int next = leakages[i];
			if (next - start >= L) {
				count++;
				start = next;
			}
		}
		System.out.println(count);

	}

}
