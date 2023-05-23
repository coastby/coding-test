package programmers.level3;

import java.util.*;

public class 이중우선순위큐 {
	public int[] solution(String[] operations) {
		StringTokenizer st;
		List<Integer> nums = new ArrayList<>();
		for (String op : operations) {
			st = new StringTokenizer(op);
			String str = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			switch(str) {
				case "I":
					nums.add(num);
					Collections.sort(nums);
					break;
				case "D":
					if (nums.size() > 0) {
						if (num > 0) {
							nums.remove(nums.size()-1);
						} else {
							nums.remove(0);
						}
					}
					break;
			}
		}
		if (nums.size() == 0) {
			return new int[]{0, 0};
		}
		int[] answer = {nums.get(nums.size()-1), nums.get(0)};
		return answer;
	}
}
