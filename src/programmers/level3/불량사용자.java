package programmers.level3;

import java.util.*;

class 불량사용자 {
	boolean[][] possible;
	Set<String> result = new HashSet<>();

	public int solution(String[] user_id, String[] banned_id) {
		possible = new boolean[user_id.length][banned_id.length];
		for (int i = 0; i < user_id.length; i++) {
			for (int j = 0; j < banned_id.length; j++) {
				if (user_id[i].length() == banned_id[j].length()) {
					int len = user_id[i].length();
					boolean contain = false;
					for (int k = 0; k < len; k++) {
						if (banned_id[j].charAt(k) == '*' || banned_id[j].charAt(k) == user_id[i].charAt(k)) {
							contain = true;
						} else {
							contain = false;
							break;
						}
					}
					possible[i][j] = contain;
				}
			}
		}

		combi(0, new boolean[user_id.length]);
		return result.size();
	}

	void combi(int banned, boolean[] visited) {
		if (banned == possible[0].length) {
			result.add(Arrays.toString(visited));
			System.out.println(Arrays.toString(visited));
			return;
		}
		for (int i = 0; i < possible.length; i++) {
			if (possible[i][banned] && !visited[i]) {
				visited[i] = true;
				combi(banned + 1, visited);
				visited[i] = false;
			}
		}
	}
}
