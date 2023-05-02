package baekjoon.ch8_문자열;

/**
 * 1. 앞자리로 인덱싱 -> 시간 초과
 * 2. 단어 길이로 인덱싱 -> 시간 초과
 * 3. hashing -> 시간 초과
 * 4. set을 이용
 * **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class N5_1764_듣보잡 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> heard = new HashSet<>();
		Set<String> seen = new HashSet<>();
		for (int i = 0; i < N; i++) {
			heard.add(br.readLine());
		}
		for (int i = 0; i < M; i++) {
			seen.add(br.readLine());
		}
		heard.retainAll(seen);

		List<String> result = new ArrayList<>(heard);
		StringBuilder sb = new StringBuilder();
		Collections.sort(result);

		sb.append(result.size()).append("\n");
		result.forEach(name -> sb.append(name).append("\n"));
		System.out.println(sb);
	}
}
