package com.edu.cnu.poker;

import lombok.Data;
/**
 * Created by dy on 2017-04-24.
 */
@Data
public class Player {
    private Hand hand;

    public Player(Hand hand){
        this.hand = hand;
    }
}
