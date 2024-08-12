package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * priority queue 사용하면 시간은 더 줄어들 듯 *
 * */
public class N703_Kth_Largest_Element_in_a_Stream {
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
}

class KthLargest {
    public int k;
    public List<Integer> nums;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());

    }

    public int add(int val) {
        nums.add(val);
        Collections.sort(nums);
        return nums.get(nums.size()-k);
    }
}
