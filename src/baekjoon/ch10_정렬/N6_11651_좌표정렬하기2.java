package baekjoon.ch10_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class N6_11651_좌표정렬하기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Map<Integer, List<Integer>> map = new TreeMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (!map.containsKey(y)) {
				map.put(y, new ArrayList<>());
			}
			map.get(y).add(x);
		}
		StringBuilder sb = new StringBuilder();
		for (int y : map.keySet()) {
			List<Integer> xs = map.get(y);
			Collections.sort(xs);
			for (int i = 0; i < xs.size(); i++) {
				sb.append(xs.get(i)).append(" ").append(y).append("\n");
			}
		}
		System.out.println(sb);
	}
}
