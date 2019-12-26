package com.leecode.pratice;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {

    public List<String> letterCombinations(String digits) {
        String[] mapping={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> resList=new ArrayList<String>();
        for(char digit:digits.toCharArray()){
            int number=Integer.parseInt(String.valueOf(digit));
            resList=combine(mapping[number],resList);
        }
        return resList;
    }

    private List<String> combine(String digitletter, List<String> list){
        List<String> res=new ArrayList<>();
        for(int i=0;i<digitletter.length();i++){
            char c=digitletter.charAt(i);
            for(String s:list){
                res.add(s+c);
            }
        }
        return res;
    }

    @Test
    public void test(){
        String a ="23";
        letterCombinations(a);
    }
}
