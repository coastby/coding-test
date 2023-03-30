package baekjoon.ch7_BFS_DFS_다익스트라;

import java.io.*;
import java.util.*;

public class N4_1012_유기농배추 {
	static boolean[][] crops;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			crops = new boolean[N][M];		//배추밭 만들기

			int K = Integer.parseInt(st.nextToken());
			for (int j = 0; j < K; j++) {		//배추 심기
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				crops[Y][X] = true;
			}

			int result = 0;
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					if (crops[k][j]) {
						result++;
						bfs(j, k);
					}
				}
			}
			System.out.println(result);
		}
	}

	static void bfs (int X, int Y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {X, Y});
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int mx = now[0] + dx[i];
				int my = now[1] + dy[i];
				if (mx >= 0 && mx < crops[0].length && my >= 0 && my < crops.length && crops[my][mx]) {
					q.add(new int[]{mx, my});
					crops[my][mx] = false;
				}
			}
		}
	}
}
