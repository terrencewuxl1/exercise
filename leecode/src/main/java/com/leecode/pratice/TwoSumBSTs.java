package com.leecode.pratice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoSumBSTs {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> list1=new ArrayList<>();
        preOrder(root1,list1);
        List<Integer> list2=new ArrayList<>();
        preOrder(root2, list2);
        Collections.sort(list1);
        Collections.sort(list2);
        for(int i=0;i<list1.size();i++){
            for(int j=0;j<list2.size();j++){
                if(list1.get(i)+list2.get(j) >target)break;
                if(list1.get(i)+list2.get(j) == target) return true;
            }
        }
        return false;
    }

    private void preOrder(TreeNode root, List<Integer> arr){
        if(root!=null){
            arr.add(root.val);
            preOrder(root.left,arr);
            preOrder(root.right,arr);
        }
    }


}

