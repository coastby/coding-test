package leetcode;

import java.util.Arrays;

public class N1768_Merge_Strings_Alternately {
    public String mergeAlternately(String word1, String word2) {
        Integer len1 = word1.length();
        Integer len2 = word2.length();
        Integer gap = len1 - len2;
        if (gap > 0) {
            for(int i = 0; i < gap; i++) word2 += " ";
        } else {
            for(int i = 0; i < -gap; i++) word1 += " ";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word1.length(); i++) {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }

        return sb.toString().replaceAll(" ", "");
    }

    public String mergeAlternately2(String word1, String word2) {
        Integer len1 = word1.length();
        Integer len2 = word2.length();
        Integer len = len1 < len2 ? len1 : len2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }
        sb.append(word1.substring(len));
        sb.append(word2.substring(len));

        return sb.toString();
    }
}
