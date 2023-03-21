package baekjoon.ch9_투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2_21921_블로그 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[] visit = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			visit[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		for (int i = 0; i < X; i++) {		// 초기화
			sum += visit[i];
		}
		int max = sum;
		int cnt = 1;
		for (int i = 1; i <= N-X; i++) {
			sum -= visit[i - 1];
			sum += visit[i + X - 1];
			if (max < sum) {
				max = sum;
				cnt = 1;
			} else if (max == sum) {
				cnt++;
			}
		}

		if (max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(cnt);
		}
	}
}
