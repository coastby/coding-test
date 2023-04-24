package baekjoon.ch4_그리디;

/**
 * 단위가 클 때는 long을 쓰자.
 * **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N5_13305_주유소 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] distances = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N-1; i++) {
			distances[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int min = Integer.parseInt(st.nextToken());
		long total = (long) min * distances[0];		//처음 주유하기

		for (int i = 1; i < N; i++) {
			int price = Integer.parseInt(st.nextToken());	//다음 주유소 가격
			if (min > price) {
				min = price;
			}
			total += (long) distances[i] * min;
		}
		System.out.println(total);

	}
}
