package baekjoon.ch10_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 	public static void main(String[] args) throws IOException {
 * 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 * 		StringBuilder sb = new StringBuilder();
 * 		int N = Integer.parseInt(br.readLine());
 *
 *         int[] nums = new int[N];
 * 		for (int i = 0; i < N; i++) {
 * 			int num = Integer.parseInt(br.readLine());
 * 			nums[i] = num;
 *                }
 *         Arrays.sort(nums);
 *         for (int i = 0; i < N; i++) {
 *             sb.append(nums[i] + "\n");
 *         }
 * 		System.out.println(sb);* 	}
 * 		**/

public class N1_2750_수정렬하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		boolean[] minus = new boolean[1001];
		boolean[] plus = new boolean[1001];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num >= 0) {
				plus[num] = true;
			} else {
				minus[-num] = true;
			}

		}
		for (int i = 1000; i > 0; i--) {
			if (minus[i]) {
				sb.append(-i + "\n");
			}
		}
		for (int i = 0; i < 1001; i++) {
			if(plus[i]) {
				sb.append(i + "\n");
			}
		}
		System.out.println(sb);
	}
}
