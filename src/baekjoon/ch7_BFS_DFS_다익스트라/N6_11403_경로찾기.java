package baekjoon.ch7_BFS_DFS_다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N6_11403_경로찾기 {
	static int N;
	static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			Arrays.stream(bfs(i)).forEach(num -> sb.append(num).append(" "));
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int[] bfs (int start) {
		int[] visited = new int[N];
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < N; i++) {
				if (graph[now][i] == 1 && visited[i] == 0) {
					q.add(i);
					visited[i] = 1;
				}
			}
		}
		return visited;
	}
}
