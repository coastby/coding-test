package baekjoon.ch3_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class N4_2776_암기왕 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			Set<Integer> memo1 = new HashSet<>();
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				memo1.add(Integer.parseInt(st.nextToken()));
			}
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (memo1.contains(Integer.parseInt(st.nextToken()))) {
					sb.append(1);
				} else {
					sb.append(0);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
