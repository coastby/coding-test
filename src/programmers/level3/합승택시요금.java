package programmers.level3;

import java.util.*;

/**
 * S -> N -> A, B
 **/

class 합승택시요금 {
	public int solution(int n, int s, int a, int b, int[][] fares) {
		long[][] map = new long[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(map[i], Integer.MAX_VALUE);
			map[i][i] = 0;
		}
		for (int i = 0; i < fares.length; i++) {
			int j = fares[i][0];
			int k = fares[i][1];
			int cost = fares[i][2];
			map[j][k] = Math.min(map[j][k], cost);
			map[k][j] = Math.min(map[k][j], cost);
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j ++) {
				for (int k = 1; k <=n; k++){
					map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
				}
			}
		}
		long min = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			min = Math.min(min, map[s][i] + map[i][a] + map[i][b]);
		}
		return (int) min;
	}
}
