package com.leecode.pratice;

public class CostToMoveChips {
    public int minCostToMoveChips(int[] chips) {
        int count1=0;
        for(int i=0;i<chips.length;i++){
            chips[i]=chips[i]%2;
            if (chips[i]==1)count1++;
        }
        if(chips.length-count1>count1){
            return count1;
        }else {
            return chips.length-count1;
        }

    }
}
