package leetcode;

import java.util.Arrays;

public class N283_Move_Zeroes {
    public void moveZeroes(int[] nums) {
        int firstZero = nums.length - 1;
        for(int i = 0; i < firstZero; i++) {
            while(nums[i] == 0 && firstZero != i){
                moveThisToThere(nums, i, firstZero--);
            }
        }
    }

    private void moveThisToThere(int[] nums, int th, int there) {
        for(int i = th; i < there; i++) {
            int tmp = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = tmp;
        }
    }

    public void moveZeroes2(int[] nums) {
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }
}
