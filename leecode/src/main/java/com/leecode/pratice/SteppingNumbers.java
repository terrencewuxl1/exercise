package com.leecode.pratice;

import java.util.ArrayList;
import java.util.List;

public class SteppingNumbers {
    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> res=new ArrayList<>();
        while (high>=low){
            if(high==0){
                res.add(0);
                break;
            }
            String highStr=String.valueOf(high);
            if(highStr.length()==1){
                res.add(Integer.parseInt(highStr));
                high--;
                continue;
            }
            int temp=0;
            for(int i=0;i<highStr.length()-1;i++){
              int deff=(int)highStr.charAt(i)-(int)highStr.charAt(i+1);
              if(Math.abs(deff)!=1){
                  temp=10^(highStr.length()-i-1);
                  break;
              }
            }
            if(temp==0){
                res.add(high);
                high /=10;
            }else {
                high=high-temp;
            }
        }
        return res;


    }
}
