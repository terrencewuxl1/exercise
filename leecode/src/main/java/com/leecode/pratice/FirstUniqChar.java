package com.leecode.pratice;

import org.junit.Test;

public class FirstUniqChar {
    public int firstUniqChar(String s) {
        int[] buffer = new int[125];
        for (char ch : s.toCharArray()) {
            buffer[ch]++;
        }
        int i = 0;
        for (char ch : s.toCharArray()) {
            if (buffer[ch] == 1) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Test
    public void test() {
        String s = "dddccdbba";
        System.out.println(firstUniqChar(s));
    }
}
