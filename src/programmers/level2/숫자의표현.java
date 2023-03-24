package programmers.level2;

public class 숫자의표현 {

	public int solution(int n) {
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < n; j++) {
				int sum = ((2*i) + j) * (j + 1) / 2;
				if (sum == n) {
					answer++;
					break;
				} else if (sum > n){
					break;
				}
			}
		}

		return answer;
	}
}
