package com.pluralsight;

public class Player { ;
    private String player;
    private Hand hand = new Hand();

    public Player(String player) {
        this.player = player;
    }

    public String getPlayer() {
        return player;
    }

    public Hand getHand() {
        return hand;
    }
}
