package baekjoon.ch9_투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1_2003_수들의합2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());

		int[] nums = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = nums[i-1] + Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int cnt = 0;

		while (left <= N) {
			for (int i = left; i <= N; i++) {
				int sum = nums[i] - nums[left];
				if (sum == M) {
					cnt++;
					break;
				} else if (sum > M) {
					break;
				}
			}
			left++;
		}
		System.out.println(cnt);
	}
}
