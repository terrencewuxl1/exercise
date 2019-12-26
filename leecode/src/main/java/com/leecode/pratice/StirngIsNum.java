package com.leecode.pratice;

import org.testng.annotations.Test;

public class StirngIsNum {

    public boolean isNumber(String s) {
        String baseNum = s.trim();
        boolean eIsNum = true;
        boolean bigIsNum = true;
        boolean smallIsNum = true;

        if (baseNum.contains("e")) {
            if (baseNum.equals("e")) return false;
            String eNum = baseNum.substring(baseNum.indexOf("e") + 1);
            baseNum = baseNum.substring(0, baseNum.indexOf("e"));
            eIsNum = eIsNum(eNum);
        }
        if (baseNum.equals(".") || baseNum.equals("")) return false;
        if (baseNum.startsWith("-") || baseNum.startsWith("+")) {
            baseNum = baseNum.substring(1);
        }
        String bigNum = baseNum;
        if (baseNum.contains(".")) {
            bigNum = baseNum.substring(0, baseNum.indexOf("."));
            String smallNum = baseNum.substring(baseNum.indexOf(".") + 1);
            smallIsNum = backIsNum(smallNum);
        }
        bigIsNum = baseIsNum(bigNum);
        return eIsNum && bigIsNum && smallIsNum;

    }

    private boolean baseIsNum(String s) {
        if (s.equals("")) return true;
        try {
            if (Long.valueOf(s) < 0) return false;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private boolean backIsNum(String s){
        if(s.startsWith("+")||s.startsWith("-"))return false;
        return baseIsNum(s);
    }

    private boolean eIsNum(String s) {
        try {
            Long.valueOf(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    @Test
    public void test() {
        String a = " 277707e26";
        System.out.println(isNumber(a));
    }
}
