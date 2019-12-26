package com.leecode.oo.design.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Card> cards;
    int point;
    boolean wantCard;

    public Player(){
        cards=new ArrayList<>();
        point=0;
    }

    public int getPoint() {
        return point;
    }

    public void getCard(Card card) {
        cards.add(card);
    }

    public void wanCard(){
        this.wantCard=true;
    }
}