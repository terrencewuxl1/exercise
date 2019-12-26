package com.leecode.pratice;

import java.util.*;

public class IntersectionArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map1=new HashMap<>();
        for(Integer num:nums1){
            if(map1.containsKey(num)){
                map1.put(num,map1.get(num)+1);
            }else {
                map1.put(num,1);
            }
        }
        List<Integer> resList=new ArrayList<>();
        for(Integer num:nums2){
            if(map1.containsKey(num)){
                if(map1.get(num)>0){
                    resList.add(num);
                    map1.put(num,map1.get(num)-1);
                }
            }
        }


        int[] d = new int[resList.size()];
        for(int i = 0;i<resList.size();i++){
            d[i] = resList.get(i);
        }

        return d;
    }
}
