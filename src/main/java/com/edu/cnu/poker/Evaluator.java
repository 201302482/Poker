package com.edu.cnu.poker;

import java.util.*;

/**
 * Created by cse on 2017-04-17.
 */
public class Evaluator {
    public HandRanking evaluate(List<Card> cardList) {
        Map<Suit, Integer> tempMap = new HashMap<Suit, Integer>();
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();

        Collections.sort(cardList);

        for (Card card : cardList) {
            if (tempMap.containsKey(card.getSuit())) {
                Integer count = tempMap.get(card.getSuit());
                count = new Integer(count.intValue() + 1);
                tempMap.put(card.getSuit(), count);
            } else {
                tempMap.put(card.getSuit(), new Integer(1));
            }

            if (countMap.containsKey(card.getRank())) {
                Integer count = countMap.get(card.getRank());
                count = new Integer(count.intValue() + 1);
                countMap.put(card.getRank(), count);
            } else {
                countMap.put(card.getRank(), new Integer(1));
            }
        }

        /* Loyal Straight Flush */
        for (Suit key : tempMap.keySet()) {
            /* if FLUSH, make new FLUSH cards List */
            if (tempMap.get(key) >= 5 && key == Suit.SPADES) {
                List newCardList = isFlushThenMakeNewCardsList(cardList, key);
                /* if FLUSH, check isBackStraight */
                if(isCardsBackStraight(newCardList)) return HandRanking.ROYAL_STRAIGHT_FLUSH;
            }
        }

        /* Straight Flush */
        for (Suit key : tempMap.keySet()) {
            List newCardList = cardList;
            /* if FLUSH, make new FLUSH cards List */
            if (tempMap.get(key) >= 5) {
                newCardList = isFlushThenMakeNewCardsList(cardList, key);
                /* if FLUSH, check isBackStraight */
                if(isCardsBackStraight(newCardList)) return HandRanking.BACK_STRAIGHT_FLUSH;
                /* if FLUSH, check isStraight */
                if(isCardsStraight(newCardList)) return HandRanking.STRAIGHT_FLUSH;
            }
        }

        /* Four Card */
        for(Integer key : countMap.keySet()){
            if(countMap.get(key) == 4) {
                return HandRanking.FOUR_CARD;
            }
        }

        /* Full house */
        for (Integer key1 : countMap.keySet()) {
            if (countMap.get(key1) >= 2) {
                for (Integer key2 : countMap.keySet()) {
                    if (countMap.get(key2) >= 3 && key1 != key2) {
                        return HandRanking.FULL_HOUSE;
                    }
                }
            }
        }

        /* Flush */
        for (Suit key : tempMap.keySet()) {
            if (tempMap.get(key) >= 5) {
                return HandRanking.FLUSH;
            }
        }

        /* Straight */
        if(isCardsBackStraight(cardList)) return HandRanking.BACK_STRAIGHT;

        /* Back Straight */
        if(isCardsStraight(cardList)) return HandRanking.STRAIGHT;

        /* Triple */
        for(Integer key : countMap.keySet()){
            if(countMap.get(key) == 3){
                return HandRanking.TRIPLE;
            }
        }

        /* Two pair*/
        int count = 0;
        for (Integer key1 : countMap.keySet()) {
            if (countMap.get(key1) == 2) {
                count++;
                if (count == 2)
                    return HandRanking.TWO_PAIR;
            }
        }

        /* One pair*/
        for (Integer key : countMap.keySet()) {
            if (countMap.get(key) == 2) {
                return HandRanking.ONE_PAIR;
            }
        }

        return HandRanking.NOTHING;
    }

    private List isFlushThenMakeNewCardsList(List<Card> cardList, Suit key) {
        ArrayList newCardList = new ArrayList<Card>();
        for (Card card : cardList) {
            if(card.getSuit() == key)
                newCardList.add(card);
        }
        return newCardList;
    }

    private boolean isCardsStraight(List<Card> cardList) {
        for (int i = 0; i < cardList.size() - 4; i++) {
            for (int index = i + 1; index < i + 5; index ++) { // 5 = HandRanking의 size
                if (cardList.get(index).getRank() - cardList.get(index - 1).getRank() != 1)
                    return false;
                if (index == i + 4) return true;
            }
        }
        return false;
    }

    private boolean isCardsBackStraight(List<Card> cardList) {
        if ( cardList.get(0).getRank() != 1 || cardList.get( cardList.size() - 4 ).getRank() != 10)
            return false;
        for (int index = cardList.size() - 3; index < cardList.size(); index++) {
            if (cardList.get(index).getRank() - cardList.get(index - 1).getRank() != 1)
                return false;
            if (index == cardList.size()-1) return true;
        }
        return false;
    }
}
