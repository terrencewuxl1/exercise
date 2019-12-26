package com.leecode.pratice;

import java.util.HashMap;
import java.util.Map;

public class Subsequence {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int a : arr) {
            if (map.containsKey(a - difference)) {
                map.put(a, map.get(a - difference) + 1);
            } else {
                map.put(a, 1);
            }
            max = Math.max(map.get(a), max);
        }
        return max;

    }
}
