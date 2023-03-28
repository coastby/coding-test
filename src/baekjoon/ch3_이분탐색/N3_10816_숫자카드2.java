package baekjoon.ch3_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class N3_10816_숫자카드2 {
	static Map<Integer, Integer> cards;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		cards = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (!cards.containsKey(n)) {
				cards.put(n, 0);
			}
			cards.put(n, cards.get(n)+1);
		}

		List<Integer> nums = cards.keySet().stream().sorted().collect(Collectors.toList());
		// toList()는 자바 11에 없음

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());

			int start = 0;
			int end = nums.size() - 1;
			int result = 0;
			while (start <= end) {
				int mid = (start + end) / 2;
				if (nums.get(mid) == num) {
					result = cards.get(num);
					break;
				} else if (nums.get(mid) > num) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
			sb.append(result).append(" ");
		}
		System.out.println(sb);
	}
}
