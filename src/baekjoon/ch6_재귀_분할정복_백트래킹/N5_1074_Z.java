package baekjoon.ch6_재귀_분할정복_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N5_1074_Z {
	static int N;
	static int count = 0;
	static int r;
	static int c;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		find(1, 0, 0);
		System.out.println(result);
	}

	static void find(int depth, int nr, int nc){
		if (depth == N+1) {
			count++;
			if (nr == r && nc == c) {
				result = count - 1;
			}
			return;
		}
		int d = (int) Math.pow(2, N - depth);
		depth++;
		if (r < nr + d && c < nc + d) {
			find(depth, nr, nc);
		} else if (r < nr + d && c >= nc + d) {
			count += d * d;
			find(depth, nr, nc + d);
		} else if (r >= nr + d && c < nc +d) {
			count += 2 * d * d;
			find(depth, nr + d, nc);
		} else {
			count += 3 * d * d;
			find(depth, nr + d, nc + d);
		}
	}
}
