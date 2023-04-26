package baekjoon.ch10_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N7_1431_시리얼번호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Guitar> guitarList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			guitarList.add(new Guitar(br.readLine()));
		}
		Collections.sort(guitarList);
		StringBuilder sb = new StringBuilder();
		guitarList.forEach(guitar -> sb.append(guitar.serial).append("\n"));
		System.out.println(sb);
	}
}

class Guitar implements Comparable<Guitar> {
	String serial;

	public Guitar(String serial) {
		this.serial = serial;
	}


	@Override
	public int compareTo(Guitar g) {
		int len = this.serial.length();
		if (this.serial.length() != g.serial.length()) {
			return len - g.serial.length();
		} else {
			int thisSum = 0;
			int gSum = 0;
			for (int i = 0; i < len; i++) {
				char tsc = this.serial.charAt(i);
				char gsc = g.serial.charAt(i);
				if ('0' <= tsc && tsc <= '9') {
					thisSum += tsc - '0';
				}
				if ('0' <= gsc && gsc <= '9') {
					gSum += gsc - '0';
				}
			}
			if (thisSum != gSum) {
				return thisSum - gSum;
			} else {
				return this.serial.compareTo(g.serial);
			}
		}
	}
}

/**
 * 다른 답안
 * import java.io.BufferedReader;
 * import java.io.IOException;
 * import java.io.InputStreamReader;
 * import java.util.Arrays;
 *
 * public class Main {
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *         int n = Integer.parseInt(br.readLine());
 *         String[] arr = new String[n];
 *         for(int i=0; i<n; i++)
 *             arr[i] = br.readLine();
 *
 *         Arrays.sort(arr, (o1, o2) -> {
 *             if(o1.length() == o2.length())
 *                 return sum(o1) == sum(o2) ? o1.compareTo(o2) : sum(o1) - sum(o2);
 *             else
 *                 return o1.length() - o2.length();
 *         });
 *
 *         for(String str : arr)
 *             System.out.println(str);
 *
 *         br.close();
 *     }
 *
 *     public static int sum(String str) {
 *         int result = 0;
 *
 *         for(char c : str.replaceAll("[^\\d]", "").toCharArray())
 *             result += c - '0';
 *
 *         return result;
 *     }
 * }
 *
 *
 * ***/
