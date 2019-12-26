package com.leecode.pratice;

public class AddOne {
    public int[] plusOne(int[] digits) {

        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]==9){
                digits[i]=0;
            }else {
                digits[i]=digits[i]+1;
                break;
            }
        }

        if(digits[0]==0){
            int[] res=new int[digits.length+1];
            res[0]=1;
            for(int i=0;i<digits.length;i++){
                res[i+1]=digits[i];
            }
            return res;
        }
        return digits;
    }
}
