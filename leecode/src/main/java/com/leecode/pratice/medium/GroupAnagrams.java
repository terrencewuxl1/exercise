package com.leecode.pratice.medium;

import java.util.*;

public class GroupAnagrams {


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> compare = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        int i=0;
        for (String s : strs) {
            String temp=sort(s);
            if (compare.containsKey(temp)) {
                res.get(compare.get(temp)).add(s);
            }else {
                compare.put(temp,i);
                List<String> nl =new ArrayList<>();
                nl.add(s);
                res.add(nl);
                i++;
            }
        }
        return res;
    }

    private String sort(String a){

        char[] arr1=a.toCharArray();
        Arrays.sort(arr1);
        String temp=String.valueOf(arr1);
        return temp;

    }
}
