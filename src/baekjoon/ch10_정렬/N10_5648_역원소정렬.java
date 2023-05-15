package baekjoon.ch10_정렬;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N10_5648_역원소정렬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
		int n = sc.nextInt();
		List<Long> list = new ArrayList<>();
		while (n-- > 0) {
			String num = sc.next();
			int idx = num.length() - 1;
			while (num.charAt(idx) == 0) {
				idx--;
			}
			sb = new StringBuilder();
			for (int i = idx; i >= 0; i--) {
				sb.append(num.charAt(i));
			}
			list.add(Long.parseLong(sb.toString()));
		}
		StringBuilder result = new StringBuilder();
		list.stream().sorted().forEach(num -> result.append(num).append("\n"));
		System.out.println(result);
	}
}
