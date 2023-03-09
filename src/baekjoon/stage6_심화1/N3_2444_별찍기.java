package baekjoon.stage6_심화1;
import java.util.*;


public class N3_2444_별찍기 {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int space = n - i - 1;
			int star = 2 * i + 1;
			sb.append(" ".repeat(space));
			sb.append("*".repeat(star));
			sb.append("\n");
		}
		for (int i = n - 2; i >= 0; i--) {
			int space = n - i - 1;
			int star = 2 * i + 1;
			sb.append(" ".repeat(space));
			sb.append("*".repeat(star));
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
