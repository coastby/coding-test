package leetcode;


import java.util.Arrays;

public class N435_Non_overlapping_Intervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (i1, i2) -> (i1[0]==i2[0] ?
                (i1[1] - i1[0]) - (i2[1] - i2[0]) : i1[0] - i2[0]));

        int[] dp = new int[n];
        int result = 0;
        dp[0] = intervals[0][1];
        for (int i = 1; i < n; i++) {
            // interval (i-1)을 사용할 때
            // 안겹치면
            if(dp[i-1] <= intervals[i][0]){
                dp[i] = intervals[i][1];
                continue;
            }

            // 겹치면 interval (i-1)을 사용하지 않을 때와 비교해서 끝이 낮은 거 선택
            result++;
            dp[i] = dp[i-1] <= intervals[i][1] ? dp[i-1] : intervals[i][1];

        }
        return result;
    }

    public int eraseOverlapIntervals2(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);

        int count = 0;
        int prev = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prev) {

                prev = intervals[i][1];
            } else {
                count++;
            }
        }

        return count;
    }
}
