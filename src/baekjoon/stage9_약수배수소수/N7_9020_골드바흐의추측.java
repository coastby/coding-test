package baekjoon.stage9_약수배수소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N7_9020_골드바흐의추측 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[] memo = notOnly();

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			for (int j = num/2; j > 1; j--) {
				if (!memo[j] && !memo[num-j]) {
					System.out.println(j + " " + (num-j));
					break;
				}
			}
		}
	}

	static boolean[] notOnly() {
		boolean[] memo = new boolean[10001];
		memo[0] = true;
		memo[1] = true;
		for (int i = 2; i*i < 10001; i++) {
			if (!memo[i]) {
				for (int j = 2; j <= 10000/i; j++) {
					memo[i*j] = true;
				}
			}
		}
		return memo;
	}
}
