package baekjoon.ch6_재귀_분할정복_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N7_15654_N과M5 {
	static int N;
	static int M;
	static int[] nums;
	static StringBuilder result = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		print(M, new StringBuilder());
		System.out.println(result);
	}

	static void print(int depth, StringBuilder sb) {
		if (depth == 0) {
			result.append(sb).append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			int now = nums[i];
			if (now != 0) {
				String add = now + " ";
				sb.append(add);
				nums[i] = 0;
				print(--depth, sb);
				depth++;
				sb.delete(sb.length() - add.length(), sb.length());
				nums[i] = now;
			}
		}
	}

}
