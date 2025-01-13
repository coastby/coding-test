package leetcode;

import java.util.*;

class N88_Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            while(p1 <  m && nums1[p1] <= nums2[i]) {
                result.add(nums1[p1++]);
            }
            result.add(nums2[i]);

            if (i == n-1) {
                while (p1 < m) {
                    result.add(nums1[p1++]);
                }
            }
        }
        for (int i = 0; i < result.size(); i++) {
            nums1[i] = result.get(i);
        }
    }

        public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p3 = m + n - 1;

        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] >= nums2[p2]) {
                nums1[p3--] = nums1[p1--];
            } else {
                nums1[p3--] = nums2[p2--];
            }
        }
    }
}