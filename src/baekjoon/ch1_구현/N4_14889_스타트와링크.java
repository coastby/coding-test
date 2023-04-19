package baekjoon.ch1_구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N4_14889_스타트와링크 {
	static int N;
	static int[][] S;
	static int min = (int) 1e9;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		S = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//N-1개에서 N/2-1개 선택하는 조합
		List<Integer> teamA = new ArrayList<>();
		teamA.add(1);
		makeTeam(teamA);
		System.out.println(min);
	}

	static void makeTeam(List<Integer> teamA){
		if (teamA.size() == N/2) {
			min = Math.min(min, gap(teamA));
			return;
		}
		int start = teamA.get(teamA.size() - 1);
		for (int i = start+1; i <= N; i++) {
			List<Integer> teamAcopy = new ArrayList<>(teamA);
			teamAcopy.add(i);
			makeTeam(teamAcopy);
		}
	}

	static int gap(List<Integer> teamA) {
		List<Integer> teamB = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if(!teamA.contains(i)) {
				teamB.add(i);
			}
		}
		int gap = getSynergy(teamA) - getSynergy(teamB);
		return Math.abs(gap);
	}

	static int getSynergy(List<Integer> team) {
		int total = 0;
		for (int i = 0; i < team.size(); i++) {
			for (int j = 0; j < team.size(); j++) {
				if (i != j) {
					int a = team.get(i);
					int b = team.get(j);
					total += S[a][b];
				}
			}
		}
		return total;
	}
}

/**
 * 다른 풀이
 *
 * import java.io.BufferedReader;
 * import java.io.IOException;
 * import java.io.InputStreamReader;
 * import java.util.StringTokenizer;
 *
 * public class Main {
 *     private static int N;
 *     private static int[][] S;
 *     private static boolean[] team;
 *     private static int min = Integer.MAX_VALUE;
 *
 *     public static void main(String[] args) throws IOException {
 *         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 *         N = Integer.parseInt(reader.readLine());
 *         team = new boolean[N];
 *         S = new int[N][N];
 *         for(int i = 0; i < N; i++) {
 *             StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
 *             for(int j = 0; j < N; j++) {
 *                 S[i][j] = Integer.parseInt(tokenizer.nextToken());
 *             }
 *         }
 *         dfs(0, 0);
 *         System.out.println(min);
 *     }
 *
 *     public static void dfs(int depth, int start) {
 *         //start 팀원(N/2명) 선택이 끝나면 나머지 인원은 자동으로 link 팀이 됨
 *         if(depth == N/2) {
 *             int teamStart = 0;
 *             int teamLink = 0;
 *             for(int i = 0; i < N - 1; i++) {
 *                 for(int j = i + 1; j < N; j++) {
 *                     if(team[i] && team[j]) {
 *                         teamStart += S[i][j];
 *                         teamStart += S[j][i];
 *                     }
 *                     if(!team[i] && !team[j]) {
 *                         teamLink += S[i][j];
 *                         teamLink += S[j][i];
 *                     }
 *                 }
 *             }
 *
 *             int gap = Math.abs(teamStart - teamLink);
 *             if(gap == 0) {
 *                 System.out.println(gap);
 *                 System.exit(0);
 *             } else if(gap < min) {
 *                 min = gap;
 *             }
 *             return;
 *         }
 *         for(int i = start; i < N; i++) {
 *             if(!team[i]) {
 *                 team[i] = true;
 *                 dfs(depth + 1, i + 1);
 *                 team[i] = false;
 *             }
 *         }
 *     }
 * }
 * **/