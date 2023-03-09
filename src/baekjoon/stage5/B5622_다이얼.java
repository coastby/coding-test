package baekjoon.stage5;

import java.util.*;

public class B5622_다이얼 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch <= 'C') {
				sum += 3;
			} else if (ch <= 'F') {
				sum += 4;
			} else if (ch <= 'I') {
				sum += 5;
			} else if (ch <= 'L') {
				sum += 6;
			} else if (ch <= 'O') {
				sum += 7;
			} else if (ch <= 'S') {
				sum += 8;
			} else if (ch <= 'V') {
				sum += 9;
			} else if (ch <= 'Z') {
				sum += 10;
			}

//			switch (ch) {
//				case 'A', 'B', 'C' -> sum += 3;
//				case 'D', 'E', 'F' -> sum += 4;
//				case 'G', 'H', 'I' -> sum += 5;
//				case 'J', 'K', 'L' -> sum += 6;
//				case 'M', 'N', 'O' -> sum += 7;
//				case 'P', 'Q', 'R', 'S' -> sum += 8;
//				case 'T', 'U', 'V' -> sum += 9;
//				case 'W', 'X', 'Y', 'Z' -> sum += 10;
//			}
		}
		System.out.println(sum);
	}
}
