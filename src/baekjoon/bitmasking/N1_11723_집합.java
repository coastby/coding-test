package baekjoon.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1_11723_집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());

		int bitset = 0;
		while (M-- > 0){
			st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			int n;
			switch (op) {
				case "all":
					bitset = (1 << 22) - 1;
					break;
				case "empty":
					bitset = 0;
					break;
				case "add":
					n = Integer.parseInt(st.nextToken());
					bitset |= 1 << n;
					break;
				case "remove":
					n = Integer.parseInt(st.nextToken());
					bitset &= ~(1 << n);
					break;
				case "check":
					n = Integer.parseInt(st.nextToken());
					sb.append((bitset & (1 << n)) != 0 ? 1 : 0).append("\n");
					break;
				case "toggle":
					n = Integer.parseInt(st.nextToken());
					bitset ^= 1 << n;
					break;
			}
		}
		System.out.println(sb);
	}

}
