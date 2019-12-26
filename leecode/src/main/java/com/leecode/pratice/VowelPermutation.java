package com.leecode.pratice;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class VowelPermutation {
    public int countVowelPermutation(int n) {
        Map<String, Double> countMap = new HashMap<>();
        if (n == 0) return 0;
        countMap.put("a", 1d);
        countMap.put("e", 1d);
        countMap.put("i", 1d);
        countMap.put("o", 1d);
        countMap.put("u", 1d);
        for (int i = 1; i < n; i++) {
            Double ac = countMap.get("a");
            Double ec = countMap.get("e");
            Double ic = countMap.get("i");
            Double oc = countMap.get("o");
            Double uc = countMap.get("u");
            countMap.replace("a", (ec + ic + uc) % 1000000007);
            countMap.replace("e", (ac + ic) % 1000000007);
            countMap.replace("i", (ec + oc) % 1000000007);
            countMap.replace("o", ic);
            countMap.replace("u", (ic + oc) % 1000000007);
            //           System.out.println(countMap.get("a")+","+countMap.get("e")+","+countMap.get("i")+","+countMap.get("o")+","+countMap.get("u"));
        }

        Double res = countMap.get("a") + countMap.get("e") + countMap.get("i") + countMap.get("o") + countMap.get("u");

        res = res % 1000000007;
        return res.intValue();
    }


    @Test
    public void test() {
        System.out.println(countVowelPermutation(144));
    }
}
