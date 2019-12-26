package com.leecode.pratice;

import org.testng.annotations.Test;

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        String temp = "";
        int length = 0;
        String res = "";
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = s.length() - i; j >0 ; j--) {
                temp = s.substring(i, i + j);
                if(temp.length()<length)break;
                int equalLength = 0;
                for (int k = 0; k < temp.length() / 2; k++) {
                    if (temp.charAt(k) != temp.charAt(temp.length() - k - 1)){
                        break;
                    }else {
                        equalLength++;
                    }

                }
                if (equalLength == temp.length() / 2 && temp.length() > length) {
                    res = temp;
                    length = temp.length();
                }
            }
        }
        return res;
    }

    @Test
    public  void main(){
        String s="bb";
        System.out.println(longestPalindrome(s));
    }

}
