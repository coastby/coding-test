package leetcode;

public class N1732_Find_the_Highest_Altitude {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int now = 0;
        for (int i = 0; i < gain.length; i++) {
            now += gain[i];
            max = max < now ? now : max;
        }
        return max;
    }
}
