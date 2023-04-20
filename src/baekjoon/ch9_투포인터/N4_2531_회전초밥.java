package baekjoon.ch9_투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class N4_2531_회전초밥 {
	static int c;
	static Map<Integer, Integer> count = new HashMap<>();
	static int updated;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		count.put(c, 1);

		int[] sushies = new int[N];
		for (int i = 0; i < k; i++) {
			int sushi = Integer.parseInt(br.readLine());
			eat(sushi);
			sushies[i] = sushi;
		}
		updated = count.keySet().size();
		int max = updated;

		for (int j = 0; j < N; j++) {
			int i = (j+k)%N;
			if(i >= k) {
				sushies[i] = Integer.parseInt(br.readLine());;
			}
			eat(sushies[i]);
			remove(sushies[j]);
			max = Math.max(max, updated);
			if (max == d) {
				System.out.println(d);
				return;
			}
		}
		System.out.println(max);
	}

	static void eat(int sushi) {
		if (!count.containsKey(sushi)) {
			count.put(sushi, 0);
			updated++;
		}
		count.put(sushi, count.get(sushi)+1);
	}

	static void remove(int sushi) {
		count.put(sushi, count.get(sushi)-1);
		if (count.get(sushi) == 0) {
			count.remove(sushi);
			updated--;
		}
	}
}
