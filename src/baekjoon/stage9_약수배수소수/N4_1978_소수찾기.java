package baekjoon.stage9_약수배수소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N4_1978_소수찾기 {

	static Boolean[] only = new Boolean[1001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		only[1] = false;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (isOnly(num)) {
				cnt++;
				only[num] = true;
			} else {
				only[num] = false;
			}
		}
		System.out.println(cnt);
	}

	static boolean isOnly(int N) {
		if (only[N] != null) {
			return only[N];
		} else {
			for (int i = 2; i < N; i++) {
				if (N % i == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
