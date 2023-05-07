package baekjoon.ch4_그리디;

/**
 * 시작 시간과 종료 시간이 같은 경우를 생각하지 못 함
 * **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class N9_1931_회의실배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		List<int[]> meetings = new ArrayList<>(); //[종료, 시작]
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int[] m = new int[2];
			m[1] = Integer.parseInt(st.nextToken());
			m[0] = Integer.parseInt(st.nextToken());
			meetings.add(m);
		}
		Collections.sort(meetings, (m1, m2) -> {
			if (m1[0] == m2[0]) {
				return m1[1] - m2[1];
			}
			return m1[0] - m2[0];
		});
		int count = 0;
		int end = 0;
		for (int i = 0; i < meetings.size(); i++) {
			if (meetings.get(i)[1] >= end) {
				end = meetings.get(i)[0];
				count++;
			}
		}
		System.out.println(count);
	}
}
