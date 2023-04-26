package baekjoon.ch8_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class N5_14426_접두사찾기 {
	static int N;
	static String[] S;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		S = new String[N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			S[i] = line;
		}
		Arrays.sort(S);
		int count = 0;
		for (int i = 0; i < M; i++) {
			String pre = br.readLine();
			if (find(pre)) count++;
		}
		System.out.println(count);
	}

	static boolean find(String pre) {
		int start = 0;
		int end = N-1;
		while (start <= end) {
			int mid = (start + end) / 2;
			String now = S[mid];
			int isPre = pre.compareTo(now.substring(0, pre.length()));
			if (isPre == 0) {
				return true;
			} else if (isPre > 0){
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
	}

}
