package baekjoon.ch9_투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class N7_10025_게으른백곰 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Bucket> buckets = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			buckets.add(new Bucket(g, x));
		}
		Collections.sort(buckets);

		int end = -1;		// 합의 마지막 인덱스
		int sum = 0;
		int result = 0;
		for (int i = 0; i < N; i++) {		// 합의 첫번째 인덱스
			if (i != 0) {
				sum -= buckets.get(i - 1).g;
			}

			for (int j = end + 1; j < N; j++) {
				if (buckets.get(j).x <= buckets.get(i).x + 2 * K) {
					sum += buckets.get(j).g;
					end++;
				} else {
					break;
				}
			}

			result = Math.max(result, sum);
		}
		System.out.println(result);

	}


}
class Bucket implements Comparable<Bucket> {
	int g;
	int x;

	public Bucket(int g, int x) {
		this.g = g;
		this.x = x;
	}

	@Override
	public int compareTo(Bucket bucket) {
		return this.x - bucket.x;
	}
}

