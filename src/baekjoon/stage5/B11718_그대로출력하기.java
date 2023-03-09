package baekjoon.stage5;
import java.io.*;


public class B11718_그대로출력하기 {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String str = br.readLine();
			if (str == null) {return;}
			else {
				System.out.println(str);
			}
		}
	}
}
