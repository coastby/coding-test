package baekjoon.ch9_투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 연속된 소수의 합으로 나타낼 수 있는 경우의 수
 * 다른 답들도 같이 보기
 * **/


public class N10_1644_소수의연속합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 1 < N < 4,000,000
		int N = Integer.parseInt(br.readLine());

		// 소수 리스트 만들기
		boolean[] nums = new boolean[N + 1];
		for (int i = 2; i < nums.length; i++) {
			if (!nums[i]) {
				for (int j = 2; j <= N / i; j++) {
					nums[i * j] = true;
				}
			}
		}
		List<Integer> onlyNums = new ArrayList<>();
		for (int i = 2; i < nums.length; i++) {
			if (!nums[i]) onlyNums.add(i);
		}


		// 투포인터 돌리기
		int left = 0;
		int sum = 0;
		int count = 0;
		// i = right
		for (int i = 0; i < onlyNums.size(); i++) {
			sum += onlyNums.get(i);
			if (sum < N) {
				continue;
			}

			while(sum > N) {
				sum -= onlyNums.get(left);
				left++;
			}

			if (sum == N) count++;
		}
		System.out.println(count);
	}
}
