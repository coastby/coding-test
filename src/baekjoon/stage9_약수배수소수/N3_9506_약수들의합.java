package baekjoon.stage9_약수배수소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class N3_9506_약수들의합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			sb.setLength(0);
			int n = Integer.parseInt(br.readLine());
			if (n == -1) {
				break;
			} else {
				ArrayList<Integer> factors = new ArrayList<>();
				int sum = 0;
				for (int i = 1; i*i <= n; i++) {
					if (n % i == 0) {
						sb.append(i + " + ");
						sum += i;
						if (i*i != n && i != 1) {
							factors.add(n / i);
							sum += n/i;
						}
					}
				}
				if (sum == n) {
					for (int i = factors.size() - 1; i > 0 ; i--) {
						sb.append(factors.get(i) + " + ");
					}
					sb.append(factors.get(0));
					System.out.println(n + " = " + sb);
				} else {
					System.out.println(n + " is NOT perfect.");
				}
			}
		}
	}
}
