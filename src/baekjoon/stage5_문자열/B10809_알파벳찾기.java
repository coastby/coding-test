package baekjoon.stage5_문자열;

import java.util.*;

public class B10809_알파벳찾기 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		for (char ch = 'a'; ch <= 'z'; ch++) {
			System.out.print(str.indexOf(ch) + " ");
		}
	}
}
