package com.leecode.pratice;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BalancedString {
    public int balancedString(String s) {
        Map<Character,Integer> num=new HashMap<>();
        for(Character c:s.toCharArray()){
            if(num.containsKey(c))num.put(c,num.get(c)+1);
            else num.put(c,1);
        }
        int stand=s.length()/4;
        int change=0;
        for(Map.Entry<Character,Integer> entry:num.entrySet()){
            if(entry.getValue()>stand)change+=entry.getValue()-stand;
        }
        System.out.println("");
        UUID id=new UUID(11111111,0);
        return change;
    }
}
