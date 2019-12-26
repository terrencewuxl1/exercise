package com.leecode.pratice.mock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CriticalConnections {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res=new ArrayList<>();
        for(List<Integer> list:connections){
            if(isCritical(list,connections))res.add(list);
        }
        return res;
    }

    private boolean isCritical(List<Integer> list, List<List<Integer>> connections){
        int i=list.get(0);
        int j=list.get(1);
        Set<Integer> third = new HashSet<>();
        for(List<Integer> list2:connections){
            if(list!=list2){
                if(list2.contains(i)||list2.contains(j)){
                    int i2=list2.get(0);
                    int j2=list2.get(1);
                    int k;
                    if(i2==i||i2==j)k=j2;
                    else k=i2;
                    if(third.contains(k))return false;
                    else third.add(k);
                }
            }
        }
        return true;
    }
}
