package leetcode;


public class N1071_Greatest_Common_Divisor_of_Strings {

    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        // str1이 더 긴 거
        if (len1 < len2) {
            String temp = str1;
            str1 = str2;
            str2 = temp;

            int tempLen = len1;
            len1 = len2;
            len2 = tempLen;
        }

        String result = "";
        // str2의 divisor 찾기
        for(int i = len2; i > 0; i--) {
            if (len2 % i == 0 && len1 % i == 0) {
                String subStr = str2.substring(0, i);
                int splitLen1 = str1.split(subStr).length;
                int splitLen2 = str2.split(subStr).length;
                if (splitLen1 == 0 && splitLen2 == 0) {
                    result = subStr;
                    break;
                }
            }
        }

        return result;
    }

    public String gcdOfStrings2(String str1, String str2) {
        // Check if concatenated strings are equal or not, if not return ""
        if (!(str1 + str2).equals(str2 + str1))
            return "";
        // If strings are equal than return the substring from 0 to gcd of size(str1), size(str2)
        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
