package baekjoon.stage2;

import java.io.*;
import java.util.*;

public class B2884_알람시계 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int hh = Integer.parseInt(st.nextToken());
		int mm = Integer.parseInt(st.nextToken()) - 45;

		if (mm < 0) {
			mm = 60 + mm;
			hh -= 1;
		}

		if (hh < 0) {
			hh = 24 + hh;
		}

		System.out.println(hh + " " + mm);
	}

}
