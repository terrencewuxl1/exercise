package com.leecode.pratice;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Parents {

    public List<String> generateParenthesis(int n) {
        List<String> curr=new ArrayList<>();
        if(n==0)return curr;
        curr.add("()");
        for(int i=2;i<=n;i++){
            curr=addParent(curr);
        }
        return curr;
    }

    private List<String> addParent(List<String> list){
        List<String> result=new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(String s:list){
            set.add("()"+s);
            set.add(s+"()");
            for(int i=0;i<s.length()-1;i++){
                set.add(s.substring(0,i+1)+"()"+s.substring(i+1,s.length()));
            }
        }
        result.addAll(set);
        result.remove(2);
        return result;
    }

    @Test
    public void test(){
        System.out.println(generateParenthesis(3));
    }
}
