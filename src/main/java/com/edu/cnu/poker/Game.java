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
    private Player player1;
    private Player player2;

    public Game(PokerType pokerType) {
        deck = new Deck(1);
        evaluator = new Evaluator();
        player1 = new Player(new Hand(deck, pokerType));
        player2 = new Player(new Hand(deck, pokerType));
    }

    public void gamePlayAndPrintResult() {
        HandRanking handRanking1 = evaluator.evaluate(player1.getHand().getCardList());
        HandRanking handRanking2 = evaluator.evaluate(player2.getHand().getCardList());
        int gameResult = isPlayer1Winner(handRanking1, handRanking2).getGameResult();

        System.out.println( "player1's cards: " + handRanking1 + "\t.... " + player1.getHand().getCards() );
        System.out.println( "player2's cards: " + handRanking2 + "\t.... " + player2.getHand().getCards() );
        if( gameResult == 0 )
            System.out.println( "Winner is player1" );
        else if( gameResult == 1 )
            System.out.println( "Draw" );
        else
            System.out.println( "Winner is player2" );
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

    public void run() {
        gamePlayAndPrintResult();
    }

}
