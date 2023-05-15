package baekjoon.ch4_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class N10_11000_강의실배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		TreeMap<Integer, List<Integer>> classes = new TreeMap<>();
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			if (!classes.containsKey(S)) {
				classes.put(S, new ArrayList<>());
			}
			classes.get(S).add(T);
		}
		PriorityQueue<Integer> end = new PriorityQueue<>();
		for (int start : classes.keySet()) {
			List<Integer> ends = classes.get(start);
			Collections.sort(ends);
			for (int i = 0; i < ends.size(); i++) {
				if (!end.isEmpty() && end.peek() <= start) {
					end.poll();
					end.add(ends.get(i));
				} else {
					end.add(ends.get(i));
				}
			}
		}

		System.out.println(end.size());
	}

}
