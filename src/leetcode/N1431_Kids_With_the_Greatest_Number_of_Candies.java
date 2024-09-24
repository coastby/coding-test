package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N1431_Kids_With_the_Greatest_Number_of_Candies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int num = candies.length;
        List<Boolean> result = new ArrayList<>();
        int max = Arrays.stream(candies).max().getAsInt();
        for (int i = 0; i < num ; i++) {
            result.add(max <= candies[i] + extraCandies);
        }
        return result;
    }
}
