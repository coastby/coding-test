package baekjoon.ch9_투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N9_20922_겹치는건싫어 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int[] count = new int[100001];
		int start = 0;
		int end = 0;
		int size = 1;
		while (end < N) {
			if (count[nums[end]] < K) {
				count[nums[end]]++;
				end++;
			} else {
				count[nums[start]]--;
				start++;
			}
			size = Math.max(size, end - start);
		}
		System.out.println(size);
	}
}
