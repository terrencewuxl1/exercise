package com.leecode.oo.design.blackjack;

import java.util.*;

public class CardSet {
    Queue<Card> cardset;

    public CardSet(){
        cardset=new LinkedList<>();
        shuffle();
    }

    public void shuffle(){
        int[] arr=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,
                1,2,3,4,5,6,7,8,9,10,11,12,13,
                1,2,3,4,5,6,7,8,9,10,11,12,13,
                1,2,3,4,5,6,7,8,9,10,11,12,13};
        for(int i=0;i<arr.length;i++){
            int j=new Random().nextInt(52);
            swap(arr,i,j);
        }
        for(int i:arr){
            this.cardset.add(new Card(i));
        }
    }

    private void swap(int[] arr,int i,int j){
        int temp=arr[j];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public Card party(){
        if(!cardset.isEmpty())return cardset.poll();
        return null;
    }

}
