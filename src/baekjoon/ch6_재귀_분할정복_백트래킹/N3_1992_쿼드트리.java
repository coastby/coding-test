package baekjoon.ch6_재귀_분할정복_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N3_1992_쿼드트리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		char[][] image = new char[N][N];

		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < N; j++) {
				image[i][j] = row.charAt(j);
			}
		}
		System.out.println(compress(image));
	}

	static String compress(char[][] image) {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		if (image.length == 1) {
			return image[0][0]+"";
		} else {
			sb.append(compress(part(image, 1)));
			sb.append(compress(part(image, 2)));
			sb.append(compress(part(image, 3)));
			sb.append(compress(part(image, 4)));
		}
		sb.append(")");

		if (sb.toString().equals("(0000)")) {
			return "0";
		} else if (sb.toString().equals("(1111)")) {
			return "1";
		} else {
			return sb.toString();
		}
	}

	static char[][] part(char[][] origin, int area) {
		int d = origin.length / 2;
		int xs = 0;
		int xe = 0;
		int ys = 0;
		int ye = 0;
		char[][] result = new char[d][d];
		switch (area) {
			case 1:
				xs = 0;
				xe = d;
				ys = 0;
				ye = d;
				break;
			case 2:
				xs = d;
				xe = d * 2;
				ys = 0;
				ye = d;
				break;
			case 3:
				xs = 0;
				xe = d;
				ys = d;
				ye = d * 2;
				break;
			case 4:
				xs = d;
				xe = d * 2;
				ys = d;
				ye = d * 2;
				break;
		}
		for (int i = ys; i < ye; i++) {
			for (int j = xs; j < xe; j++) {
				result[i - ys][j-xs] = origin[i][j];
			}
		}
		return result;
	}

}
