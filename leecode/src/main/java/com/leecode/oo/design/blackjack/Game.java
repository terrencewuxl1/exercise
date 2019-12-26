package com.leecode.oo.design.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players;
    CardSet cardSet;

    public Game(){
        players=new ArrayList<>();
        cardSet=new CardSet();
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void firstRoundPartyCards(){
        for(Player player:players){
           player.getCard(cardSet.party());
           player.getCard(cardSet.party());
        }
    }

//    public Player judge(){
//
//    }



}
