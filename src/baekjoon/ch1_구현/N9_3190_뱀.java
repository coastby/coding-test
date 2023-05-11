package baekjoon.ch1_구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class N9_3190_뱀 {
	static int N;
	static int[][] board;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int count = 0;
	static int[] info = {0, 0, 1}; //[row, col, dir], 0: 위, 1: 오, 2: 아, 3: 왼
	static Queue<int[]> body = new LinkedList<>();


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());	// 보드의 크기
		board = new int[N][N];
		int K = Integer.parseInt(br.readLine());	// 사과의 갯수
		for (int i = 0; i < K; i++) {				// 사과 보드에 등록
			st = new StringTokenizer(br.readLine());
			board[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 4;
		}
		int L = Integer.parseInt(br.readLine());	// 방향 전환 정보
		TreeMap<Integer, String> direction = new TreeMap<>();
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			direction.put(Integer.parseInt(st.nextToken()), st.nextToken());
		}

		body.add(new int[] {0, 0});
		board[0][0] = 1;

		for (Map.Entry<Integer, String> d : direction.entrySet()) {
			int sec = d.getKey() - count;
			String dir = d.getValue();

			while (sec-- > 0) {
				int nr = info[0] + dr[info[2]];
				int nc = info[1] + dc[info[2]];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && board[nr][nc] != 1) {
					goStraight(nr, nc);
				} else {
					System.out.println(count + 1);
					return;
				}
			}
			switch (dir) {
				case "D":
					info[2] = (info[2] + 1) % 4;
					break;
				case "L":
					info[2] = (info[2] + 3) % 4;
					break;
			}

		}

		while (true) {		//방향 전환 끝난 후 직진
			int nr = info[0] + dr[info[2]];
			int nc = info[1] + dc[info[2]];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && board[nr][nc] != 1) {
				goStraight(nr, nc);
			} else {
				System.out.println(count + 1);
				return;
			}
		}

	}

	static void goStraight (int nr, int nc) {
		info[0] = nr;
		info[1] = nc;
		body.add(new int[] {nr, nc});
		if (board[nr][nc] != 4) {
			int[] tail = body.poll();
			board[tail[0]][tail[1]] = 0;
		}
		board[nr][nc] = 1;
		count++;
	}
}
