package com.edu.cnu.poker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by dy on 2017-04-25.
 */
public class GameTest {
        @Test
        public void Game의_Player_수는_2명이다() {
            Game game = new Game(2);
        }
        @Test
        public void TWO_PAIR로_ONE_PAIR을이긴다(){
            Game game = new Game(2);
            HandRanking twoPair = HandRanking.TWO_PAIR;
            HandRanking onePair = HandRanking.ONE_PAIR;
            Result gameResult = game.isPlayer1Winner(twoPair,onePair);
            assertThat(gameResult,is(Result.WIN));
        }
}




