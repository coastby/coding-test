package programmers.level3;

import java.util.*;

public class 보석쇼핑 {

	public static void main(String[] args) {
		String[] q1 = {"AA", "AB", "AC", "AA", "AC"};
		System.out.println(Arrays.toString(solution(q1)));
	}

	public static int[] solution(String[] gems) {
		int total = (int) Arrays.stream(gems).distinct().count();
		Map<String, Integer> pocket = new HashMap<>();

		int right = 0;
		int left = 0;
		int min = gems.length + 1;
		pocket.put(gems[0], 1);
		int[] answer = new int[2];
		while (right != gems.length-1) {
			while (pocket.size() < total && right < gems.length-1) {
				right++;
				if (!pocket.containsKey(gems[right])) {
					pocket.put(gems[right], 0);
				}
				pocket.put(gems[right], pocket.get(gems[right]) + 1);
			}
			while (pocket.size() == total) {
				if (pocket.get(gems[left]) == 1) {
					pocket.remove(gems[left]);
				} else {
					pocket.put(gems[left], pocket.get(gems[left]) - 1);
				}
				left++;
			}
			if ((right - left + 2) == total) {
				answer[0] = left;
				answer[1] = right + 1;
				return answer;
			} else if ((right - left + 2) < min) {
				min = right - left + 2;
				answer[0] = left;
				answer[1] = right + 1;
			}
		}
		return answer;
	}
}