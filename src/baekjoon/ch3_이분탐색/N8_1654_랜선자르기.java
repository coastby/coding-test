package baekjoon.ch3_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N8_1654_랜선자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] lans = new int[K];
		long end = 0;
		for (int i = 0; i < K; i++) {
			lans[i] = Integer.parseInt(br.readLine());
			end = Math.max(end, lans[i]);
		}
		long start = 1;

		while (start <= end) {
			long mid = (start + end) / 2;
			long count = 0;
			for (int i = 0; i < K; i++) {
				count += lans[i] / mid;
			}
			if (count >= N) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(end);
	}
}
