package com.leecode.pratice;

import org.testng.annotations.Test;

public class Anagram {
    public boolean isAnagram(String s, String t) {
        int[] buffer = new int[125];
        for (char ch : s.toCharArray()) {
            buffer[ch]++;
        }
        for (char ch : t.toCharArray()) {
            buffer[ch]--;
        }
        for(Integer i:buffer){
            if(i!=0)return false;
        }
        return true;
    }

    @Test
    public void test(){
        String s="12312345sdfa";
        String t="bcxvbsdfsfd";
        isAnagram(s,t);
    }
}
