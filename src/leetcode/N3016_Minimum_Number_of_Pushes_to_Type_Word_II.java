package leetcode;

import java.util.Arrays;

public class N3016_Minimum_Number_of_Pushes_to_Type_Word_II {
    public int minimumPushes(String word) {
        int result = 0;
        int[] alphCount = new int[26];

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            alphCount[ch-97]++;

        }
        Arrays.sort(alphCount);

        int click = 1;
        for(int i = 25; i >= 0; i--) {
            int realClick = click + (25-i)/8;
            result += alphCount[i] * realClick;

        }
        return result;
    }
}
