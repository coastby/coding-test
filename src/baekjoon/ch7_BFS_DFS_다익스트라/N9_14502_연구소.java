package baekjoon.ch7_BFS_DFS_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N9_14502_연구소 {
	static int N;
	static int M;
	static int[][] lab;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int result = 0;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lab = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		comb(0, 0);
		System.out.println(result);


	}

	static int safeArea() {
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (lab[i][j] == 2 && !visited[i][j]) {
					bfs(visited, new int[]{i, j});
				}
			}
		}
		int safe = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && lab[i][j] == 0) safe++;
			}

		}
		return safe;
	}

	static void bfs(boolean[][] visited, int[] start) {
		Queue<int[]> q = new LinkedList<>();
		q.add(start);
		visited[start[0]][start[1]] = true;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && lab[nr][nc] == 0) {
					q.add(new int[]{nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
	}

	static void comb(int depth, int start) {
		if (depth == 3) {
			result = Math.max(result, safeArea());
			return;
		}
		for (int i = start; i < N * M; i++) {
			if (lab[i/M][i%M] == 0) {
				lab[i/M][i%M] = 1;
				comb(depth + 1, i + 1);
				lab[i/M][i%M] = 0;
			}
		}
	}

}
