package baekjoon.ch3_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N6_2343_기타레슨 {
	static int M;
	static int[] lessons;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lessons = new int[N];
		int max = 0;
		int min = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			lessons[i] = Integer.parseInt(st.nextToken());
			max += lessons[i];
			min = Math.max(min, lessons[i]);
		}

		while (max >= min) {
			int mid = (min + max) / 2;
			if (isEnough(mid)) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		System.out.println(min);

	}

	static boolean isEnough(int length) {
		boolean result = true;
		int temp = M;
		int res = length;
		for (int i = 0; i < lessons.length; i++) {
			res -= lessons[i];
			if (res < 0) {
				res = length - lessons[i];
				if (--temp == 0) {
					result = false;
					break;
				}
			}
		}
		return result;
	}
}
