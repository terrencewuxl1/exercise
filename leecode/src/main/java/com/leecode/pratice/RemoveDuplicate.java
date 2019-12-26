package com.leecode.pratice;

public class RemoveDuplicate {

    public int removeDuplicates(int[] nums) {
        int[] numsTemp = nums;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
