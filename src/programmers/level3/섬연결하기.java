package programmers.level3;

import java.util.*;
public class 섬연결하기 {
	int[] parent;

	public int solution(int n, int[][] costs) {
		Arrays.sort(costs, (c1, c2) -> c1[2] - c2[2]);
		parent = new int[n];
		for (int i = 1; i < n; i++) {
			parent[i] = i;
		}
		int total = 0;
		int count = 0;
		for (int i = 0; i < costs.length; i++) {
			int a = costs[i][0];
			int b = costs[i][1];
			if (findParent(a) != findParent(b)) {
				union(a, b);
				total += costs[i][2];
				count++;
			}
			 if (count == n - 1) break;
		}
		return total;
	}

	int findParent(int a) {
		if (parent[a] == a) {
			return a;
		}
		return findParent(parent[a]);
	}

	void union(int a, int b) {
		int fa = findParent(a);
		int fb = findParent(b);
		if (fa < fb) {
			parent[fb] = fa;
		} else {
			parent[fa] = fb;
		}
	}
}
