package com.edu.cnu.poker;

public enum HandRanking {
    ROYAL_STRAIGHT_FLUSH(11),
    BACK_STRAIGHT_FLUSH(10),
    STRAIGHT_FLUSH(9),
    FOUR_CARD(8),
    FULL_HOUSE(7),
    FLUSH(6),
    BACK_STRAIGHT(5),
    STRAIGHT(4),
    TRIPLE(3),
    TWO_PAIR(2),
    ONE_PAIR(1),
    NOTHING(0); //High card

    private int rankOfHand;

    HandRanking(int rankOfHand) {
        this.rankOfHand = rankOfHand;
    } //construtor
    public int getRankOfHand() {
        return this.rankOfHand;
    }
}
