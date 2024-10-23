package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N2215_Find_the_Difference_of_Two_Arrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        List<Integer> dup = new ArrayList<>(set1);
        for(int i = 0; i < nums2.length; i++) {
            if(dup.contains(nums2[i])) {
                set1.remove(nums2[i]);
            } else {
                set2.add(nums2[i]);
            }
        }

        return List.of(new ArrayList<>(set1), new ArrayList<>(set2));
    }
}
