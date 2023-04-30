package baekjoon.ch7_BFS_DFS_다익스트라;

/**
 * //DFS함수
 *     public static void DFS(int depth, int sum) {
 *         if (depth == N) {
 *             if (sum == S) answer++;
 *             return;
 *         }
 *         //tree를 생각해서 직접 그려보면 이해하기가 쉽습니다.
 *         DFS(depth + 1, sum + num[depth]);
 *         DFS(depth + 1, sum);
 *     }
 * **/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N8_1182_부분수열의합 {
	static int N;
	static int S;
	static Integer[] nums;
	static int length;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		nums = new Integer[N];
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N + 1; i++) {
			length = i;
			getSum(0, 0, -1);
		}


		System.out.println(count);


	}

	static void getSum(int depth, int sum, int last) {
		if (depth == length) {
			if (sum == S) {
				count++;
			}
			return;
		}
		for (int i = last + 1; i < N; i++) {
			getSum(++depth, sum + nums[i], i);
		}
	}


}
