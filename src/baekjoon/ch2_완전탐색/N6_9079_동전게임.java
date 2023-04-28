package baekjoon.ch2_완전탐색;

/**
 * 처음에는 8개를 다 탐색하려고 하였다. -> 시간 개오래 걸림
 *
 * **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N6_9079_동전게임 {
	static boolean[] memo = new boolean[8];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			char[][] coins = new char[3][3];
			setCoins(coins, br);
			int result = count(coins, 0) == 9 ? -1 : count(coins, 0);
			System.out.println(result);
 		}
	}

	static void setCoins(char[][] coins, BufferedReader br) throws IOException {
		for (int j = 0; j < 3; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int k = 0; k < 3; k++) {
				coins[j][k] = st.nextToken().charAt(0);
			}
		}
	}

	static int count(char[][] coins, int depth) {
		if (isOver(coins)) {
			return depth;
		}
		if (depth >= 8) {
			return 9;
		}

		int min = 9;

		for (int i = 0; i < 3; i++) {        //가로 뒤집기
			if (!memo[i]) {
				for (int j = 0; j < 3; j++) {
					turnOver(coins, i, j);
				}
				memo[i] = true;
				min = Math.min(min, count(coins, ++depth));
				memo[i] = false;
				for (int j = 0; j < 3; j++) {
					turnOver(coins, i, j);
				}
				depth--;
			}

			if (!memo[i + 3]) {
				for (int j = 0; j < 3; j++) {
					turnOver(coins, j, i);
				}
				memo[i+3] = true;
				min = Math.min(min, count(coins, ++depth));
				memo[i+3] = false;
				for (int j = 0; j < 3; j++) {
					turnOver(coins, j, i);
				}
				depth--;
			}
		}
		if(!memo[6]) {
			for (int i = 0; i <3 ; i++) {
				turnOver(coins, i, i); // \ 대각선
			}
			memo[6] = true;
			min = Math.min(min, count(coins, ++depth));
			memo[6] = false;
			for (int i = 0; i <3 ; i++) {
				turnOver(coins, i, i); // \ 대각선
			}
			depth--;
		}
		if (!memo[7]) {
			for (int i = 0; i < 3; i++) {
				turnOver(coins, i, 2-i);
			}
			memo[7] = true;
			min = Math.min(min, count(coins, ++depth));
			memo[7] = false;
			for (int i = 0; i < 3; i++) {
				turnOver(coins, i, 2-i);
			}
			depth--;
		}
		return min;
	}

	static boolean isOver(char[][] coins) {
		char start = coins[0][0];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (coins[i][j] != start) {
					return false;
				}
			}
		}
		return true;
	}

	static void turnOver(char[][] coins, int i, int j) {
		if (coins[i][j] == 'H'){
			coins[i][j] = 'T';
		} else {
			coins[i][j] = 'H';
		}
	}

}
