package baekjoon.stage8_기본수학1;

import java.util.Scanner;

public class N2_1193_분수찾기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();

		int col = 1;
		while (true) {
			X = X - col;
			if (X > 0) {
				col++;
			} else {
				if ((col % 2) == 0) {
					System.out.println((col+X) + "/" + (-X+1));
				} else {
					System.out.println((-X+1) + "/" + (col+X));
				}
				break;
			}
		}
	}
}
