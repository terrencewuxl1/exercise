package com.leecode.pratice;


import java.util.Arrays;

public class SingleNumber {
    public int singleNumber(int[] nums){
        Arrays.sort(nums);
        int i=0;
        while (i<nums.length-1){
          if(nums[i]!=nums[i+1])return nums[i];
          i+=2;
        }
        return nums[nums.length];
    }
}
