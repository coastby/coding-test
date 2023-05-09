package baekjoon.ch3_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N9_2110_공유기설치 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] houses = new int[N];
		for (int i = 0; i < N; i++) {
			int house = Integer.parseInt(br.readLine());
			houses[i] = house;
		}

		int min = 1;
		Arrays.sort(houses);
		int max = (houses[N-1] - houses[0]) / (C-1);
		int result = 0;
		while (min <= max) {
			int mid = (min + max) / 2;
			int count = 1;
			int wifiHouse = houses[0];
			for (int i = 1; i < N; i++) {
				if (houses[i] - wifiHouse >= mid) {
					count++;
					wifiHouse = houses[i];
				}
			}
			if (count < C) {
				max = mid - 1;
			} else {
				result = Math.max(result, mid);
				min = mid + 1;
			}
		}
		System.out.println(result);
	}
}
/**
 * 		int min = 1;
 * 		Arrays.sort(houses);
 * 		int max = (houses[N-1] - houses[0]) / (C-1) + 1;
 * 		while (min < max) {
 * 			int mid = (min + max) / 2;
 * 			int count = 1;
 * 			int wifiHouse = houses[0];
 * 			for (int i = 1; i < N; i++) {
 * 				if (houses[i] - wifiHouse >= mid) {
 * 					count++;
 * 					wifiHouse = houses[i];
 *                                }* 			}
 * 			if (count < C) {
 * 				max = mid;
 * 			} else {
 * 				min = mid + 1;
 *                    }
 * 		}
 * 		System.out.println(min - 1);
 * **/
