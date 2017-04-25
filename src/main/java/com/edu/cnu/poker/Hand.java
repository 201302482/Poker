package com.edu.cnu.poker;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * Created by cse on 2017-04-17.
 */
@Data
public class Hand {

    private Deck deck;
    private PokerType pokerType;
    private List<Card> cardList;

    public Hand(Deck deck, PokerType pokerType) {
        this.deck = deck;
        this.pokerType = pokerType;
        cardList = new ArrayList<Card>();
        for (int i = 0; i < pokerType.getNumberOfCard(); i++) {
            cardList.add(deck.drawCard());
        }
    }

    public int getTotalCard() {
        return cardList.size();
    }

    public String getCards(){
        StringBuffer cardBuf = new StringBuffer();
        for(int i = 0; i < cardList.size(); i++)
            cardBuf.append("[" + cardList.get(i).getSuit() + ", " + cardList.get(i).getRank() + "]  ");
        return cardBuf.toString();
    }
}
