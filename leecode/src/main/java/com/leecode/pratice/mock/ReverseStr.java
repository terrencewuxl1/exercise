package com.leecode.pratice.mock;

import org.testng.annotations.Test;

public class ReverseStr {
    public String reverseStr(String s, int k) {

        int i=0;
        StringBuffer sb=new StringBuffer();
        while(i<s.length()){
            if(i+k*2<s.length()){
                sb.append(reverse(s.substring(i,i+k))+s.substring(i+k,i+2*k));
            }else if(i+k<s.length()){
                sb.append(reverse(s.substring(i,i+k))+s.substring(i+k));
            }else{
                sb.append(reverse(s.substring(i)));
            }
            i+=k*2;
        }
        return sb.toString();
    }

    private String reverse(String s){
        char[] c=s.toCharArray();
        int i=0;
        int j=s.length()-1;
        while(i<j){
            char temp=c[i];
            c[i]=c[j];
            c[j]=temp;
            i++;
            j--;
        }
        return String.valueOf(c);
    }

    @Test
    public void test(){
        System.out.println(reverseStr("abcdefg",2));
    }
}
