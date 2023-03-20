package baekjoon.ch7_BFS_DFS_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2_2468_안전영역 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] area = new int[N][N];
		int min = 101;
		int max = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, area[i][j]);
				max = Math.max(max, area[i][j]);
			}
		}

		int result = 1;

		for (int i = min; i < max; i++) {
			int[][] map = copyArray(area);
			result = Math.max(result, countArea(map, i));
		}
		System.out.println(result);
	}

	static int[][] copyArray(int[][] origin) {
		int[][] b = new int[origin.length][origin[0].length];

		for (int i = 0; i < origin.length; i++) {
			for (int j = 0; j < origin[i].length; j++) {
				b[i][j] = origin[i][j];
			}
		}
		return b;
	}

	static int countArea(int[][] area, int height) {
		int count = 0;

		for (int i = 0; i < area.length; i++) {
			for (int j = 0; j < area.length; j++) {
				if (area[i][j] > height) {
					findArea(area, height, new int[]{i, j});

					count++;
				}
			}
		}
		return count;
	}

	static void findArea(int[][] area, int height, int[] start) {
		int[] dx = {-1, 0, 0, 1};
		int[] dy = {0, -1, 1, 0};

		Queue<int[]> q = new LinkedList<>();
		q.add(start);
		while (!q.isEmpty()) {
			int[] now = q.poll();
			area[now[0]][now[1]] = 0;
			for (int i = 0; i < 4; i++) {
				int mx = now[1] + dx[i];
				int my = now[0] + dy[i];
				if (mx >= 0 && mx < area.length && my >= 0 && my < area.length) {
					if (area[my][mx] > height) {
						area[my][mx] = 0;
						q.add(new int[]{my, mx});
					}
				}
			}
		}
	}

}
