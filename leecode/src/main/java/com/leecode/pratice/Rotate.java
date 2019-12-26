package com.leecode.pratice;


import org.junit.Test;

public class Rotate {
    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    @Test
    public void test(){
        int[] a= new int[]{1,2,3,4,5,6,7};
        rotate(a,3);
        System.out.println(a[4]);
    }
}
