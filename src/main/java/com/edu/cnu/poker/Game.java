package com.edu.cnu.poker;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by dy on 2017-04-25.
 */
@Data
public class Game {
    private Deck deck;
    private Evaluator evaluator;
    private List<Player> player;

    public Game(int playerNumber) {
        deck = new Deck(1);
        evaluator = new Evaluator();
        player = new ArrayList<Player>();

        for(int i = 0; i < playerNumber; i++) {
            player.add(new Player(new Hand(deck, PokerType.FIVE)));
        }
    }

    public void gamePlayAndPrintResult() {
        HandRanking handRanking = evaluator.evaluate(player.get(0).getHand().getCardList());
        System.out.printf( "Winner: " + "player" + "0" + "\nCards: " + handRanking );
    }

    public Result isPlayer1Winner(HandRanking handRankingOfPlayer1, HandRanking handRankingOfPlayer2){
        if( handRankingOfPlayer1.getRankOfHand() > handRankingOfPlayer2.getRankOfHand() ){
            return Result.WIN;
        }
        else if(handRankingOfPlayer1.getRankOfHand() == handRankingOfPlayer2.getRankOfHand() ){
            return Result.DRAW;
        }
        else    return Result.LOSE;
    }

    public void run(){
        gamePlayAndPrintResult();
    }

}
