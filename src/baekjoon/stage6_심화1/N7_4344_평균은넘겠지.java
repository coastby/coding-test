package baekjoon.stage6_심화1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N7_4344_평균은넘겠지 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		for (int i = 0; i < C; i++) {
			String[] scores = br.readLine().split(" ");
			int[] scoresNum = new int[scores.length];
			int sum = 0;
			for (int j = 1; j < scores.length; j++) {
				int score = Integer.parseInt(scores[j]);
				sum += score;
				scoresNum[j-1] = score;
			}
			int finalSum = sum;
			long over = Arrays.stream(scoresNum).filter(s -> s > finalSum / (scores.length-1)).count();
			System.out.printf("%.3f", (double) over / (scores.length-1) * 100);
			System.out.println("%");
		}
	}
}
