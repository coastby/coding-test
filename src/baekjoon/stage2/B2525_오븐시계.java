package baekjoon.stage2;

import java.io.*;
import java.util.*;

public class B2525_오븐시계 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int hh = Integer.parseInt(st.nextToken());
		int mm = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(br.readLine());
		int th = hh + time / 60;
		int tm = mm + time % 60;

		if (tm >= 60) {
			tm -= 60;
			th++;
		}
		if (th >= 24) {
			th %= 24;
		}

		System.out.println(th + " " + tm);

		/**
		 *      이전 답
		 * 		Scanner sc = new Scanner(System.in);
		 *
		 * 		int A = sc.nextInt();
		 * 		int B = sc.nextInt();
		 * 		int C = sc.nextInt();
		 *
		 * 		int M = B + C;
		 * 		int H = A + M/60;
		 * 		M = M%60;
		 * 		H = H%24;
		 * **/
	}
}
