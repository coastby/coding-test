package baekjoon.ch3_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N7_6236_용돈관리 {
	static int N;
	static int M;
	static int[] budget;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		budget = new int[N];
		int min = 1;
		int max = 0;
		for (int i = 0; i < N; i++) {
			budget[i] = Integer.parseInt(br.readLine());
			min = Math.max(min, budget[i]);
			max += budget[i];
		}


		while (min <= max) {
			int mid = (min + max) / 2;
			if (isOk(mid)) {
				max = mid - 1 ;
			} else {
				min = mid + 1;
			}
		}
		System.out.println(min);
	}

	static boolean isOk(int K) {
		int count = 0;
		int wallet = 0;
		for (int i = 0; i < N; i++) {
			int need = budget[i];
			if (wallet < need) {
				count++;
				wallet = K;
			}
			wallet -= need;
			if (count > M) {
				return false;
			}
		}
		return true;
	}
}
