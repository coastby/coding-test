package baekjoon.ch7_BFS_DFS_다익스트라;

/**
 * 1) BFS/DFS
 * 2) 서로소 집합
 * **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class N3_11724_연결요소의개수_서로소 {
	static int[] group;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		group = new int[N+1];

		for (int i = 1; i <= N; i++) {
			group[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			union(n1, n2);
		}

		Set<Integer> groups = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			groups.add(findRoot(group[i]));
		}
		System.out.println(groups.size());
	}

	static int findRoot(int a) {
		if (group[a] != a) {
			return findRoot(group[a]);
		}
		return a;
	}

	static void union (int a, int b) {		//a > b
		a = findRoot(a);
		b = findRoot(b);

		if (a > b) {
			group[a] = b;
		} else {
			group[b] = a;
		}
	}

}
