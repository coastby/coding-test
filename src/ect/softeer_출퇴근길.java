package ect;

/**
 * 1. A -> B로 가는 경로의 수
 * 2. 사이클 찾기
 *
 * 강한 연결 요소 (Strongly Connected Component)
 * **/

import java.util.*;
import java.io.*;

public class softeer_출퇴근길 {

	static int n;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());   //노드 수
		int m = Integer.parseInt(st.nextToken());   //간선의 수

		List<Integer>[] graph = new ArrayList[n + 1];
		List<Integer>[] graphReverse = new ArrayList[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if(graph[start] == null) {
				graph[start] = new ArrayList<>();
			}
			graph[start].add(end);
			if (graphReverse[end] == null) {
				graphReverse[end] = new ArrayList<>();
			}
			graphReverse[end].add(start);
		}

		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		boolean[] bfs1 = bfs(S, T, graph);			//S -> N
		boolean[] bfs4 = bfs(T, T, graphReverse);	//N -> T
		boolean[] bfs3 = bfs(T, S, graph);			//T -> N
		boolean[] bfs2 = bfs(S, S, graphReverse);	//N -> T

		int count = 0;
		for (int i = 0; i <= n; i++) {
			if (bfs1[i] && bfs2[i] && bfs3[i] && bfs4[i]) {
				count++;
			}
		}
		System.out.println(count);
	}

	static boolean[] bfs (int start, int end, List<Integer>[] graph) {
		boolean[] visited = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			if (graph[now] != null) {
				for (int i = 0; i < graph[now].size(); i++) {
					int next = graph[now].get(i);
					if (!visited[next] && next != end) {
						q.add(next);
						visited[next] = true;
					}

				}
			}
		}
		return visited;
	}

}
