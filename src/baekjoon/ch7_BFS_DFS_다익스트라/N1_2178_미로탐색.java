package baekjoon.ch7_BFS_DFS_다익스트라;

/**
 * BFS
 * **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1_2178_미로탐색 {
	public static final int INF = (int) 1e9;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] miro = new int[N][M];
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				if (row.charAt(j) == '1') {
					miro[i][j] = INF;
				} else {
					miro[i][j] = 0;
				}
			}
		}

		int[] row = {1, 0, 0, -1};
		int[] col = {0, 1, -1, 0};

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{0, 0});
		miro[0][0] = 1;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int mx = now[1]+col[i];
				int my = now[0]+row[i];
				if (mx >= 0 && mx < M && my >= 0 && my < N){
					if (miro[my][mx] > miro[now[0]][now[1]] + 1) {
						miro[my][mx] = miro[now[0]][now[1]] + 1;
						q.add(new int[]{my, mx});
					}
				}
			}
		}
		System.out.println(miro[N-1][M-1]);
	}
}
