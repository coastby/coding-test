package baekjoon.ch7_BFS_DFS_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N7_2667_단지번호붙이기 {
	static int N;
	static int[][] map;
	static int[] mr = new int[] {1, -1, 0, 0};
	static int[] mc = new int[] {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				char ch = line.charAt(j);
				if (ch == '0') {
					map[i][j] = 0;
				} else {
					map[i][j] = 1;
				}
			}
		}

		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					result.add(count(i, j));
				}
			}
		}
		Collections.sort(result);
		System.out.println(result.size());
		result.forEach(System.out::println);

	}

	static int count(int r, int c){
		int result = 0;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{r, c});
		map[r][c] = 0;
		result++;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int[] next = new int[]{now[0] + mr[i], now[1] + mc[i]};
				if (next[0] >= 0 && next[0] < N && next[1] >= 0 && next[1] < N) {
					if (map[next[0]][next[1]] == 1) {		//방문하지 않은 집이면
						q.add(next);
						map[next[0]][next[1]] = 0;
						result++;
					}
				}
			}
		}
		return result;
	}

}
