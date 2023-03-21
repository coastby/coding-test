package baekjoon.ch4_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N2_11047_동전0 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Integer> coins = new ArrayList<>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			coins.add(Integer.parseInt(br.readLine()));
		}
		for (int i = N-1; i >= 0; i--) {
			cnt += K / coins.get(i);
			K %= coins.get(i);
		}
		System.out.println(cnt);
	}
}
