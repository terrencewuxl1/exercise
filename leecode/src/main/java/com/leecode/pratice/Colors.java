package com.leecode.pratice;

import org.junit.Test;

public class Colors {

    public void sortColors(int[] nums) {
        int left=0, right=nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0 && i!=left){
                int temp=nums[i];
                nums[i]=nums[left];
                nums[left]=temp;
                i--;
                left++;
            }
            if(nums[i]==2 && i != right){
                int temp=nums[i];
                nums[i]=nums[right];
                nums[right]=temp;
                i--;
                right--;
            }
        }
    }

    @Test
    public void test(){
        sortColors(new int[]{2,0,2,1,1,0});
    }
}
