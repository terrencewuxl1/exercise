package com.leecode.pratice;

import org.junit.Test;

public class CountAndSayStr {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        if(n==2)return "11";
        String nStr="11";
        for (int i = 3; i <= n; i++) {
            StringBuffer sb = new StringBuffer();
            int count = 1;
            for (int j = 1; j < nStr.length(); j++) {
                if (nStr.charAt(j - 1) == nStr.charAt(j)) {
                    count++;
                } else {
                    sb.append(String.valueOf(count) + nStr.charAt(j - 1));
                    count = 1;
                }
            }
            sb.append(String.valueOf(count) + nStr.charAt(nStr.length() - 1));
            nStr = sb.toString();
        }
        return nStr;
    }

    @Test
    public void test(){
        System.out.println(countAndSay(6));
    }
}
