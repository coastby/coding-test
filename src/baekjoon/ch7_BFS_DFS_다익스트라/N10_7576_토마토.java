package baekjoon.ch7_BFS_DFS_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N10_7576_토마토 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());		//가로 칸
		int N = Integer.parseInt(st.nextToken());		//세로 칸
		int[][] tomatoes = new int[N][M];
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				switch (st.nextToken()) {
					case "1":
						tomatoes[i][j] = 0;
						q.add(new int[]{i, j});
						break;
					case "-1":
						tomatoes[i][j] = -1;
						break;
					case "0" :
						tomatoes[i][j] = N*M;
						break;
				}
			}
		}
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int today = tomatoes[now[0]][now[1]];
			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				if (0 <= nr && nr < N && 0 <= nc && nc < M && tomatoes[nr][nc] > today+1) {
					tomatoes[nr][nc] = today + 1;
					q.add(new int[]{nr, nc});
				}
			}
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomatoes[i][j] == N*M) {
					System.out.println(-1);
					return;
				}
				max = Math.max(max, tomatoes[i][j]);
			}
		}
		System.out.println(max);
	}

}
