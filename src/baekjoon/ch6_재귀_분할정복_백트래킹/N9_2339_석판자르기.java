package baekjoon.ch6_재귀_분할정복_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N9_2339_석판자르기 {
	static int N;
	static int[][] pan;
	static List<int[]> dirt;
	static List<int[]> crystal;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		pan = new int[N][N];
		dirt = new ArrayList<>();
		crystal = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
				if (pan[i][j] == 1) {
					dirt.add(new int[]{i, j});
				} else if (pan[i][j] == 2) {
					crystal.add(new int[]{i, j});
				}
			}
		}
		int result = cut(new int[]{0, N - 1}, new int[]{0, N - 1}, true);
		System.out.println(result);
	}

	static int cut(int[] rRange, int[] cRange, boolean horizon) {	//true : 가로, false: 세로
		List<int[]> dirts = new ArrayList<>();
		for (int i = rRange[0]; i <= rRange[1]; i++) {
			for (int j = cRange[0]; j <= cRange[1]; j++) {
				if (pan[i][j] == 1) dirts.add(new int[] {i, j});
			}
		}
		if (dirts.size() == 0) {
			return isOk(rRange, cRange);
		}

		int result = 0;
		for (int i = 0; i < dirts.size(); i++) {
			int[] now = dirts.get(i);
			boolean pass = false;
			if (horizon) {
				for (int j = cRange[0]; j <= cRange[1] ; j++) {
					if (pan[now[0]][j] == 2) pass = true;
				}
				if (pass) continue;
				result += (now[0] != rRange[0] ? cut(new int[]{rRange[0], now[0]-1}, cRange, !horizon) : 1)
						* (now[0] != cRange[1] ? cut(new int[]{now[0] + 1, cRange[1]}, cRange, !horizon) : 1);

			} else {
				for (int j = rRange[0]; j <= rRange[1]; j++) {
					if (pan[j][now[1]] == 2) pass = true;
				}
				if (pass) continue;
				result +=  (now[1] != cRange[0] ? cut(rRange, new int[]{cRange[0], now[1] - 1}, !horizon) : 1)
						* (now[1] != cRange[1] ? cut(rRange, new int[]{now[1] + 1, cRange[1]}, !horizon) : 1);
			}
		}
		return result;
	}

	static int isOk(int[] rRange, int[] cRange) {
		boolean[][] visited = new boolean[N][N];
		int[] only = new int[]{-1, -1};
		for (int i = 0; i < crystal.size(); i++) {
			int[] now = crystal.get(i);
			if (rRange[0] <= now[0] && now[0] <= rRange[1] && now[1] >= cRange[0] && now[1] <= cRange[1]) {
				only[0] = now[0];
				only[1] = now[1];
			}
		}
		if (only[0] == -1) return 0;

		Queue<int[]> q = new LinkedList<>();
		q.add(only);
		visited[only[0]][only[1]] = true;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dr[0];
				int nc = now[1] + dc[1];
				if (rRange[0] <= nr && nr <= rRange[1] && cRange[0] <= nc && nc <=cRange[1] && !visited[nr][nc]) {
					if (pan[nr][nc] != 0) return 0;
					q.add(new int[]{nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
		return 1;
	}



}
