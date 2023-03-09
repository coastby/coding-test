package baekjoon.stage5_문자열;
import java.io.*;

/**
 * trim() : '\u0020' 이하의 공백들만 제거
 * strip() : 유니코드 공백들을 모두 제거
 *
 * strip()이 더 공백을 확실하게 제거할 수 있다.
 * **/

public class B1152_단어의개수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		if (str.equals("")){
			System.out.println(0);
			return;
		}
		String[] words = str.split(" ");
		System.out.println(words.length);
	}
}
