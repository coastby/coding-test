package baekjoon.stage3;

import java.io.*;
import java.util.*;

/**
 *         while((input = br.readLine()) != null){
 *         }
 * **/

public class B10951_AB4 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			try {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				bw.write(a+b+"/n");
				bw.flush();
			} catch (Exception e) {
				break;
			}
		}
		bw.close();
		br.close();
	}
}
