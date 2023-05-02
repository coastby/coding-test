package baekjoon.ch9_투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N8_3273_두수의합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		int x = Integer.parseInt(br.readLine());

		int count = 0;

		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				if (nums[i] + nums[j] == x) {
					count++;
					break;
				} else if (nums[i] + nums[j] > x) {
					break;
				}
			}
		}

		System.out.println(count);

	}

}

