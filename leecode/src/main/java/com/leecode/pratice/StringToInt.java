package com.leecode.pratice;

import org.junit.Test;

public class StringToInt {

    public int strToInt(String str) {
        str = str.trim();
        if(str==null||str.equals(""))return 0;
        String numStr = "";
        String signStr=str.substring(0,1);
        if(signStr.equals("+")||signStr.equals("-")){
            if(str.length()==1)return 0;
            str=str.substring(1);
        }
        if(!Character.isDigit(str.charAt(0)))return 0;
        for(int i=0;i<str.length();i++){
            if(!Character.isDigit(str.charAt(i)))break;
            numStr=numStr+ str.charAt(i);
        }

        if(!signStr.equals("-"))signStr="";

        try {
            return Integer.valueOf(signStr+numStr);
            } catch (ArithmeticException | NumberFormatException e) {
            return signStr.equals("-")?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }
    }

    @Test
    public void test(){
        String s="3.1534";
        System.out.println(strToInt(s));
    }
}
