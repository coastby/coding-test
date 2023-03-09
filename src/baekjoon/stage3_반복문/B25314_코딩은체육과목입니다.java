package baekjoon.stage3_반복문;

import java.io.*;

public class B25314_코딩은체육과목입니다 {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()) / 4;
		for (int i = 0; i < N; i++) {
			System.out.print("long ");
		}
		System.out.print("int");
	}
}
