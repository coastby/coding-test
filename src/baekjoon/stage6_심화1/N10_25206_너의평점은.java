package baekjoon.stage6_심화1;
import java.io.*;
import java.util.*;

public class N10_25206_너의평점은 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		double total = 0;
		double scores = 0;
		double pass = 0;
		for (int i = 0; i < 20; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			double score = Double.parseDouble(st.nextToken());
			String gradeStr = st.nextToken();
			double grade = 0.0;
			switch (gradeStr) {
				case "A+" -> grade = 4.5;
				case "A0" -> grade = 4.0;
				case "B+" -> grade = 3.5;
				case "B0" -> grade = 3.0;
				case "C+" -> grade = 2.5;
				case "C0" -> grade = 2.0;
				case "D+" -> grade = 1.5;
				case "D0" -> grade = 1.0;
				case "F" -> grade = 0.0;
				case "P" -> {
					grade = 0.0;
					pass += score;
				}
				default -> System.out.println(gradeStr);
			}
			total += score * grade;
			scores += score;
		}
		System.out.println(total/(scores - pass));
	}
}
