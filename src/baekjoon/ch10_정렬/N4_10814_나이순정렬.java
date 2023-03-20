package baekjoon.ch10_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N4_10814_나이순정렬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<String>[] users = new ArrayList[201];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			if (users[age] == null) {
				users[age] = new ArrayList<>(List.of(name));
			} else {
				users[age].add(name);
			}
		}
		for (int i = 0; i < 201; i++) {
			if (users[i] != null) {
				final int age = i;
				users[age].stream().forEach(x -> System.out.println(age + " " + x));
			}
		}
	}
}
