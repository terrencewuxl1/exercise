package com.leecode.pratice.medium;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSub {
    public List<String> removeSubfolders(String[] folder) {
        //Sort the list
        Arrays.sort(folder);
        String temp=folder[0];
        List<String> res = new ArrayList<>();
        res.add(temp);
        for(int i = 1; i < folder.length; i++)
        {
            // Check if the string StartsWith or not. If not, add to the result list
            if(!(folder[i].startsWith(temp + "/")))
            {
                res.add(folder[i]);
                temp = folder[i];
            }
        }

        return res;
    }

    @Test
    public void test(){
        String[] a=new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"};
        List<String> res=removeSubfolders(a);
    }


}
