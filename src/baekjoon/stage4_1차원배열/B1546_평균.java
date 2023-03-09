package baekjoon.stage4_1차원배열;

import java.io.*;
import java.util.*;

/**
 * 원래 평균 : (A + B + C) / 3
 * 조작 평균 : (A/A*100 + B/A*100 + C/A*100) / 3
 *           = 원래 평균 / A * 100
 * **/

public class B1546_평균 {
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] scores = br.readLine().split(" ");
		OptionalDouble avg = Arrays.stream(scores).mapToInt(Integer::parseInt).average();
		OptionalInt max = Arrays.stream(scores).mapToInt(Integer::parseInt).max();

		System.out.println(avg.getAsDouble() / max.getAsInt() * 100);
	}
}
