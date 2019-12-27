package com.leecode.pratice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupPeople {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList<>());
            list.add(i);
            map.put(groupSizes[i],list);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (Integer k : map.keySet()) {
            List<Integer> list = map.get(k);
            if (list.size() == k) {
                result.add(new ArrayList<>(list));
                continue;
            } else {
                int num = 0;
                List<Integer> temp = new ArrayList<>();
                for (Integer i : list) {
                    temp.add(i);
                    num++;
                    if (num == k) {
                        result.add(new ArrayList<>(temp));
                        num = 0;
                        temp.clear();
                    }
                }
            }
        }
        return result;
    }

    @Test
    public void test(){
        int[] a={3,3,3,3,3,1,3};
        System.out.println(groupThePeople(a));
    }
}
