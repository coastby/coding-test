package baekjoon.ch3_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2_2512_예산 {
	static int[] request;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		request = new int[N];		//예산요청
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			request[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());

		if (Arrays.stream(request).sum() <= M) {
			System.out.println(Arrays.stream(request).max().getAsInt());
			return;
		}

		// 이분 탐색 : min - 1 max - 예산-N
		int start = 1;
		int end = M - N + 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (getTotal(mid) > M) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(end);
	}

	static int getTotal(int max) {
		int total = 0;
		for (int budget: request) {
			total += Math.min(budget, max);
		}
		return total;
	}
}
