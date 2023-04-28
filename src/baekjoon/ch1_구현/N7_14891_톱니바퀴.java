package baekjoon.ch1_구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N7_14891_톱니바퀴 {
	static String[] chains = new String[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 4; i++) {
			chains[i] = br.readLine();
		}
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int chain = Integer.parseInt(st.nextToken()) - 1;
			int direction = Integer.parseInt(st.nextToken());
			play(chain, direction);
		}
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sum += (int) Math.pow(2, i) * (chains[i].charAt(0) - '0');
		}
		System.out.println(sum);
	}

	static void play(int chain, int direction) {
		leftSide(chain - 1, -direction);
		rightSide(chain + 1, -direction);
		rotate(chain, direction);	//처음꺼 돌리기
	}

	static void leftSide(int chain, int direction) {
		if (chain >= 0 && chains[chain + 1].charAt(6) != chains[chain].charAt(2)) {
			leftSide(chain - 1, -direction);
			rotate(chain, direction);	//처음꺼 돌리기
		}
	}
	static void rightSide(int chain, int direction) {
		if (chain < 4 && chains[chain - 1].charAt(2) != chains[chain].charAt(6)) {
			rightSide(chain + 1, -direction);
			rotate(chain, direction);	//처음꺼 돌리기
		}
	}

	static void rotate(int chain, int direction) {
		String previous = chains[chain];
		if (direction == 1) {
			chains[chain] = previous.substring(7) + previous.substring(0, 7);
		} else {
			chains[chain] = previous.substring(1) + previous.substring(0, 1);
		}
	}
}
