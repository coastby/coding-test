package baekjoon.ch7_BFS_DFS_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N5_1260_DFS와BFS {
	static int[][] graph;
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		graph = new int[N+1][N+1];
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1;
			graph[b][a] = 1;
		}

		dfs(V);
		sb.append("\n");
		bfs(V);
		System.out.println(sb);
	}

	static void dfs(int now) {
		graph[0][now] = 1;
		sb.append(now).append(" ");
		for (int i = 1; i <= N; i++) {
			if (graph[now][i] == 1 && graph[0][i] != 1) {
				dfs(i);
			}
		}
	}

	static void bfs(int start) {
		Queue<Integer> deque = new LinkedList<>();
		deque.add(start);
		graph[start][0] = 1;
		while (!deque.isEmpty()) {
			int now = deque.poll();
			sb.append(now).append(" ");
			for (int i = 1; i <= N; i++) {
				if (graph[now][i] == 1 && graph[i][0] == 0) {
					deque.add(i);
					graph[i][0] = 1;
				}
			}
		}
	}
}
