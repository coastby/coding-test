package baekjoon.stage4;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 배열을 문자열로 변환하기
 * **/

public class B10810_골넣기 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] basket = new int[N];
		for (int n = 0; n < M; n++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			for (int m = i; m <= j; m++) {
				basket[m-1] = k;
			}

			// 대체 가능
			Arrays.fill(basket, i-1, j, k);
		}
		String result = Arrays.stream(basket).mapToObj(String::valueOf).collect(Collectors.joining(" "));
		System.out.println(result);
	}
}
