package baekjoon.ch1_구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 가장 처음 아기 상어 크기 2
 *
 * **/
public class N6_16236_아기상어 {
	static int N;
	static int[][] space;
	static int size = 2; //아기 상어 크기
	static int[] shark;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		space = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				space[i][j] = value;
				if (value == 9) {
					shark = new int[]{i, j};
				}
			}
		}
		int result = 0;
		int temp = size;
		while (true) {
			int[] r = bfs(shark[0], shark[1]);
			if (r[2] > 0) {
				result += r[2];
				temp--;
				if (temp == 0) {
					size++;
					temp = size;
				}
			} else {
				break;
			}
		}
		System.out.println(result);
	}

	static int[] bfs(int r, int c) {
		int[][] visited = new int[N][N];
		List<int[]> meals = new ArrayList<>();
		Queue<int[]> deque = new LinkedList<>();
		deque.add(new int[]{r, c});
		visited[r][c] = 1;
		while (!deque.isEmpty()) {
			int[] now = deque.poll();
			for (int i = 0; i < 4; i++) {
				int mr = now[0] + dr[i];
				int mc = now[1] + dc[i];
				if (mr >= 0 && mr < N && mc >= 0 && mc < N && (visited[mr][mc] == 0 || visited[mr][mc] > visited[now[0]][now[1]] + 1)) {
					if (space[mr][mc] == 0 || space[mr][mc] == size) {
						deque.add(new int[]{mr, mc});
						visited[mr][mc] = visited[now[0]][now[1]] + 1;
					} else if (space[mr][mc] < size) {
						meals.add(new int[]{mr, mc});
						visited[mr][mc] = visited[now[0]][now[1]] + 1;
					}
				}
			}
		}
		if (meals.isEmpty()) {
			return new int[]{r, c, 0};
		} else {
			int min = (int) 1e9;
			int[] loc = new int[2];
			for (int i = 0; i < meals.size(); i++) {
				int distance = visited[meals.get(i)[0]][meals.get(i)[1]] - 1;
				if (min > distance) {
					min = distance;
					loc[0] =  meals.get(i)[0];
					loc[1] =  meals.get(i)[1];
				} else if (min == distance) {
					if (loc[0] > meals.get(i)[0]) {
						loc[0] =  meals.get(i)[0];
						loc[1] =  meals.get(i)[1];
					} else if (loc[0] == meals.get(i)[0]) {
						if (loc[1] > meals.get(i)[1]) {
							loc[0] =  meals.get(i)[0];
							loc[1] =  meals.get(i)[1];
						}
					}
				}
			}
			space[r][c] = 0;
			space[loc[0]][loc[1]] = 9;
			shark[0] = loc[0];
			shark[1] = loc[1];
			return new int[]{loc[0], loc[1], min};
		}
	}


}
