package com.leecode.pratice;

public class RomanToInt {
    public int romanToInt(String s) {
        int res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='I')res++;
            if(s.charAt(i)=='V')res+=5;
            if(s.charAt(i)=='X')res+=10;
            if(s.charAt(i)=='L')res+=50;
            if(s.charAt(i)=='C')res+=100;
            if(s.charAt(i)=='D')res+=500;
            if(s.charAt(i)=='M')res+=1000;
            if(i>0) {
                if (s.charAt(i) == 'D' || s.charAt(i) == 'M') {
                    if(s.charAt(i-1)=='C')res-=200;
                }
                if (s.charAt(i) == 'L' || s.charAt(i) == 'C') {
                    if(s.charAt(i-1)=='X')res-=20;
                }
                if (s.charAt(i) == 'V' || s.charAt(i) == 'X') {
                    if(s.charAt(i-1)=='I')res-=2;
                }
            }
        }
        return res;


    }
}
