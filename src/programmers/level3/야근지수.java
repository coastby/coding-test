package programmers.level3;

import java.util.*;

class 야근지수 {
	public long solution(int n, int[] works) {
		Arrays.sort(works);
		int min = 0;
		int max = works[works.length-1];

		while (min < max) {
			int mid = (min + max) / 2;

			int res = n;
			boolean result = true;
			for (int i = works.length-1; i >= 0; i--) {
				if (works[i] > mid) {
					if (res < works[i] - mid) {
						result = false;
						break;
					}
					res -= works[i] - mid;
				} else {
					break;
				}
			}


			if (result) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}

		long answer = 0;

		for (int i = 0; i < works.length; i++) {
			if (works[i] > min) {
				n -= works[i] - min;
				works[i] = min;
			}
			answer += works[i] * works[i];
		}


		for (int i = 0; i < n; i++) {
			if (works[works.length - i - 1] == 0) break;
			answer += (works[works.length - i - 1] - 1) * (works[works.length - i - 1] - 1);
			answer -= works[works.length - i - 1] * works[works.length - i - 1];
		}


		return answer;
	}
}
