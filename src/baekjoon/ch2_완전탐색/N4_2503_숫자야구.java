package baekjoon.ch2_완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class N4_2503_숫자야구 {
	static List<String> memo = init();


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String mh = st.nextToken();
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());
			memo = memo.stream().filter(num -> {
				int sCheck = 0;
				List<Character> strikes = new ArrayList<>();
				for (int k = 0; k < 3; k++) {
					if (num.charAt(k) == mh.charAt(k)) {
						strikes.add(num.charAt(k));
						sCheck++;
					}
				}
				int bCheck = 0;
				for (int k = 0; k < 3; k++) {
					if (num.charAt(k) == mh.charAt((k+1)%3) || num.charAt(k) == mh.charAt((k+2)%3)) {
						if (!strikes.contains(num.charAt(k))) {
							bCheck++;
						}
					}
				}
				return strike == sCheck && ball == bCheck;
			}).collect(Collectors.toList());

		}
		System.out.println(memo);
	}

	static List<String> init() {
		List<String> memo = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				for (int k = 1; k < 10; k++) {
					if (i != j && j != k && k != i) {
						StringBuilder sb = new StringBuilder();
						sb.append(i).append(j).append(k);
						memo.add(sb.toString());
					}
				}
			}
		}
		return memo;
	}

}
