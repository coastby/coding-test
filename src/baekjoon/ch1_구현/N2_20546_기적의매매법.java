package baekjoon.ch1_구현;

import java.util.Scanner;

public class N2_20546_기적의매매법 {
	static int[] graph = new int[14];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int budget = sc.nextInt();

		for (int i = 0; i < 14; i++) {
			graph[i] = sc.nextInt();
		}

		int bnp = bnp(budget);
		int timing = timing(budget);

		if (bnp > timing) {
			System.out.println("BNP");
		} else if (bnp < timing) {
			System.out.println("TIMING");
		} else {
			System.out.println("SAMESAME");
		}

	}

	static int bnp(int budget) {
		int buy = 0;
		for (int i = 0; i < 14; i++) {
			int n = budget/graph[i];
			buy += n;
			budget %= graph[i];
		}
		return (buy * graph[13]) + budget;
	}

	static int timing(int budget) {
		int buy = 0;
		int yesterday = graph[0];
		String change = " ";
		for (int i = 1; i < 14; i++) {
			if (yesterday < graph[i]) {
				if (change.charAt(0) != '+') {
					change = "+";
				} else {
					change = change + "+";
				}
			} else if (yesterday > graph[i]){
				if (change.charAt(0) != '-') {
					change = "-";
				} else {
					change = change + "-";
				}
			}
			yesterday = graph[i];
			if (change.contains("---")) {
				int n = budget/graph[i];
				buy += n;
				budget %= graph[i];
			} else if (change.contains("+++")) {
				budget += graph[i] * buy;
				buy = 0;
			}
		}
		return (buy * graph[13]) + budget;
	}
}
