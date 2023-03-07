package baekjoon.stage4;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class B5597_과제안내신분 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> nums = IntStream.rangeClosed(1, 30).boxed().collect(Collectors.toList());

		for (int i = 0; i < 28; i++) {
			int n = sc.nextInt();
			nums.remove(nums.indexOf(n));
		}
		Collections.sort(nums);
		System.out.println(nums.get(0));
		System.out.println(nums.get(1));
	}

}
