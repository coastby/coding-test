package baekjoon.ch10_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class N5_2529_부등호 {
	static int k;
	static List<String> nums = new ArrayList<>();
	static String[] ops;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		ops = new String[k];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			ops[i] = st.nextToken();
		}

		boolean[] used = new boolean[10];
		for (int i = 0; i <= 9; i++) {
			used[i] = true;
			StringBuilder sb = new StringBuilder();
			sb.append(i);
			makeNums(sb, used, k, i);
			used[i] = false;
		}
		Collections.sort(nums);

		System.out.println(nums.get(nums.size()-1));
		System.out.println(nums.get(0));
	}

	static void makeNums(StringBuilder sb, boolean[] used, int depth, int last) {
		if (depth == 0) {
			nums.add(sb.toString());
			return;
		}
		for (int i = 0; i <= 9; i++) {
			if (!used[i] && decision(ops[k - depth], last, i)) {
				sb.append(i);
				used[i] = true;
				makeNums(sb, used, depth-1, i);
				sb.setLength(sb.length()-1);
				used[i] = false;
			}
		}
	}

	static boolean decision (String op, int a, int b) {
		if (op.equals(">")) {
			return a > b;
		} else {
			return a < b;
		}
	}

}
