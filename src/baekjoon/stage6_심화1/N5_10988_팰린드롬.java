package baekjoon.stage6_심화1;

import java.util.Scanner;

public class N5_10988_팰린드롬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();

		for (int i = 0; i < word.length()/2; i++) {
			if (word.charAt(i) != word.charAt(word.length()-i-1)) {
				System.out.println(0);
				return;
			}
		}
		System.out.println(1);
	}
}
