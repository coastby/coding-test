package baekjoon.ch8_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class N8_14425_문자열집합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<String>[] wordHash = new List[500];
		Arrays.fill(wordHash, new ArrayList<String>());
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			wordHash[hash(word)].add(word);
		}
		int count = 0;
		for (int i = 0; i < M; i++) {
			String word= br.readLine();
			List<String> hashList = wordHash[hash(word)];
			if (hashList.contains(word)) count++;
		}
		System.out.println(count);
	}

	static int hash(String word){
		int num = 0;
		for (int i = 0; i < word.length(); i++) {
			num += word.charAt(i) * i;
		}
		return num % 500;
	}

}
