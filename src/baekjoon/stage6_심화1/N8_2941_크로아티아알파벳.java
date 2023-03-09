package baekjoon.stage6_심화1;

import java.util.Scanner;

public class N8_2941_크로아티아알파벳 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		String[] alpha = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

		for (int i = 0; i < 8; i++) {
			while (word.contains(alpha[i])) {
				word = word.replace(alpha[i], "a");
			}
		}
		System.out.println(word.length());
	}
}
