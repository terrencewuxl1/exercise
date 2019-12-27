package com.leecode.pratice;

import org.junit.Test;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {

        for (int i = nums.length - 2; i >= 0; i--) {
            int zerolength = 0;
            if (nums[i] == 0) {
                zerolength += 1;
                for (int j = i; j < nums.length - zerolength; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length - zerolength] = 0;
            }
        }
    }

    @Test
    public void test() {
        int[] a = new int[]{4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        moveZeroes(a);
    }

}
