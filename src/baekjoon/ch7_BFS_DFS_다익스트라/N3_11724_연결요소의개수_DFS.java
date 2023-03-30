package baekjoon.ch7_BFS_DFS_다익스트라;

/**
 * 1) BFS/DFS
 * 2) 서로소 집합
 * **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class N3_11724_연결요소의개수_DFS {
	static boolean[][] edges;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		edges = new boolean[N+1][N+1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			edges[n1][n2] = true;
			edges[n2][n1] = true;
		}
		int count = 0;
		for (int i = 1; i < N+1; i++) {
			if (!visited[i]) {
				count++;
				dfs(i);
			}
		}
		System.out.println(count);
	}

	static void dfs (int a) {
		Queue<Integer> q = new LinkedList<>();
		q.add(a);
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 1; i < visited.length; i++) {
				if (edges[now][i] & !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}


}
