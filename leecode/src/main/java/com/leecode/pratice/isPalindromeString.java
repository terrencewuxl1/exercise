package com.leecode.pratice;

import org.junit.Test;

public class isPalindromeString {
    public boolean isPalindrome(String s) {

        s = s.toUpperCase();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start)) || s.charAt(start) == ' ') start++;
            if (!Character.isLetterOrDigit(s.charAt(end)) || s.charAt(end) == ' ') end--;
            if (Character.isLetterOrDigit(s.charAt(start)) && Character.isLetterOrDigit(s.charAt(end))) {
                if (s.charAt(start) != s.charAt(end)) return false;
                start++;
                end--;
            }
        }
        return true;
    }

    @Test
    public void test() {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
