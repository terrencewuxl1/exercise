package com.leecode.pratice;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numRows;i++) {
            list.add(new ArrayList<>());
            list.get(i).add(1);
        }
        for(int i=2;i<numRows;i++){
            list.get(i-1).add(1);
            for(int j=i+1;j<numRows;j++){
                list.get(j).add(list.get(j-1).get(i-2)+list.get(j-1).get(i-1));
            }
        }
        return list;
    }
}
