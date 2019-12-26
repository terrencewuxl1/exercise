package com.leecode.pratice;

import org.testng.annotations.Test;

public class StrStr {

    public int strStr(String haystack, String needle) {
        if(needle==null||needle.equals(""))return 0;
        for(int i=0;i<=haystack.length()-needle.length();i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                String temp=haystack.substring(i,i+needle.length());
                if(temp.equals(needle))return i;
            }
        }
        return -1;
    }

    @Test
    public void test(){
        String a="hello";
        String b="ll";
        System.out.println(strStr(a,b));
    }
}
