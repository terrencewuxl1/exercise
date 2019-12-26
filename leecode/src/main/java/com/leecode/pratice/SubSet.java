package com.leecode.pratice;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(result,curr,nums,0,0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> curr, int[] nums, int pos, int index){
        result.add(new ArrayList(curr));
        if(pos==nums.length)return;

        for(int i=index;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            curr.add(nums[i]);
            backtrack(result,curr,nums,pos+1,i);
            curr.remove(curr.size()-1);
        }
    }

    @Test
    public void test(){
        int[] a=new int[]{1,2,2};
        subsetsWithDup(a);
    }
}
