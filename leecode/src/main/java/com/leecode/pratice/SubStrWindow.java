package com.leecode.pratice;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class SubStrWindow {
    public String minWindow(String s, String t) {
        if(s.equals(t))return s;
        if(s==null||s.equals("")||s.length()<=t.length())return "";
        int left=0;
        int right=0;
        Map<Character,Integer> map = new HashMap<>();
        int minbegin=0;
        int minLength=Integer.MAX_VALUE;
        int count=0;
        for(char c:t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        while(right<s.length()){
            char sr=s.charAt(right);
            if(map.containsKey(sr)&&map.get(sr)>0){
                count++;
                map.put(sr,map.get(sr)-1);
            }
            while(count==t.length()){
                if(right-left<minLength){
                    minLength=right-left;
                    minbegin=left;
                }
                char sl=s.charAt(left);
                if(map.containsKey(sl)){
                    count--;
                    map.put(sl,map.get(sl)+1);
                }
                left++;
            }
            right++;
        }
        return s.substring(minbegin,minbegin+minLength);
    }

    @Test
    public void test(){
        minWindow("ADOBECODEBANC",
                "ABC");
    }
}
