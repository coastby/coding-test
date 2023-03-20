package baekjoon.ch10_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 정렬 라이브러리 이용하면 시간초과
 * */

public class N3_15688_수정렬하기5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			nums[i] = num;
		}
		Arrays.sort(nums);
		for (int i = 0; i < N; i++) {
			sb.append(nums[i] + "\n");
		}
		System.out.println(sb);
	}

}
