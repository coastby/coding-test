package baekjoon.ch1_구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N8_15686_치킨배달 {
	static int M;
	static int[][] bbqList;
	static int result = Integer.MAX_VALUE;
	static List<int[]> bbq;
	static List<int[]> house;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		bbqList = new int[M][2];
		bbq = new ArrayList<>();
		house = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int val = Integer.parseInt(st.nextToken());
				if (val == 2) {
					bbq.add(new int[]{i, j});
				} if (val == 1) {
					house.add(new int[]{i, j});
				}
			}
		}
		getDistance(0, 0);
		System.out.println(result);

	}

	static void getDistance(int depth, int start) {
		if (depth == M) {
			int total = 0;
			for (int i = 0; i < house.size(); i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					int y = Math.abs(house.get(i)[0] - bbqList[j][0]);
					int x = Math.abs(house.get(i)[1] - bbqList[j][1]);
					min = Math.min(min, x + y);
				}
				total += min;
			}
			result = Math.min(result, total);
			return;
		}
		for (int i = start; i < bbq.size(); i++) {
			bbqList[depth][0] = bbq.get(i)[0];
			bbqList[depth][1] = bbq.get(i)[1];
			getDistance(depth + 1, i + 1);
		}
	}


}
