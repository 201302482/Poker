package com.edu.cnu.poker;

/**
 * Created by com on 2017-04-25.
 */
public enum Result {
    WIN(0),
    DRAW(1),
    LOSE(2);

    private int gameResult;

    Result(int result) {
        this.gameResult = result;
    } //construtor
    public int getRankOfHand() {
        return this.gameResult;
    }
}
