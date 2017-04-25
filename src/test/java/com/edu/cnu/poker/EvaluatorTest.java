package com.edu.cnu.poker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by cse on 2017-04-17.
 */
public class EvaluatorTest {

    @Test
    public void SUIT가_5개가동일하면_플러쉬다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(4, Suit.CLUBS),
                new Card(8, Suit.CLUBS),
                new Card(13, Suit.CLUBS),
                new Card(2, Suit.CLUBS)
        );
        HandRanking result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRanking.FLUSH));
    }

    @Test
    public void 숫자가_2개가동일하면_원페어다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(2,Suit.DIAMONDS),
                new Card(2, Suit.HEARTS),
                new Card(7, Suit.DIAMONDS),
                new Card(9, Suit.SPADES),
                new Card(12, Suit.CLUBS)
        );
        HandRanking result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRanking.ONE_PAIR));
    }
    @Test
    public void 숫자가_3개가동일하면_트리플이다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(2,Suit.DIAMONDS),
                new Card(2, Suit.HEARTS),
                new Card(2, Suit.DIAMONDS),
                new Card(9, Suit.SPADES),
                new Card(12, Suit.CLUBS)
        );
        HandRanking result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRanking.TRIPLE));
    }
    @Test
    public void 숫자가_2개가동일한것이_두쌍있으면_투페어다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(2,Suit.DIAMONDS),
                new Card(2, Suit.HEARTS),
                new Card(7, Suit.DIAMONDS),
                new Card(7, Suit.SPADES),
                new Card(12, Suit.CLUBS)
        );
        HandRanking result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRanking.TWO_PAIR));
    }

    @Test
    public void 숫자가_4개가동일한것이있으면_포카드이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(7, Suit.DIAMONDS),
                new Card(2, Suit.HEARTS),
                new Card(7, Suit.DIAMONDS),
                new Card(7, Suit.SPADES),
                new Card(7, Suit.CLUBS)
        );
        HandRanking result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRanking.FOUR_CARD));
    }

    @Test
    public void 숫자가_3개가동일한것과_2개가동일한것이_한쌍씩있으면_풀하우스다 () {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(2, Suit.DIAMONDS),
                new Card(2, Suit.HEARTS),
                new Card(7, Suit.DIAMONDS),
                new Card(7, Suit.SPADES),
                new Card(2, Suit.CLUBS)
        );
        HandRanking result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRanking.FULL_HOUSE));
    }

    @Test
    public void 숫자가_5번연속되면_스트레이트이다 () {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(5, Suit.DIAMONDS),
                new Card(4, Suit.HEARTS),
                new Card(3, Suit.DIAMONDS),
                new Card(2, Suit.SPADES),
                new Card(1, Suit.CLUBS)
        );
        HandRanking result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRanking.STRAIGHT));
    }

    @Test
    public void 숫자가_5번연속이고_같은모양이면_스트레이트플러쉬이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.DIAMONDS),
                new Card(2, Suit.DIAMONDS),
                new Card(3, Suit.DIAMONDS),
                new Card(4, Suit.DIAMONDS),
                new Card(5, Suit.DIAMONDS)
        );
        HandRanking result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRanking.STRAIGHT_FLUSH));
    }

    @Test
    public void 숫자가_5번연속이고_모양이_스페이드면_로얄스트레이트플러쉬이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.SPADES),
                new Card(10, Suit.SPADES),
                new Card(11, Suit.SPADES),
                new Card(12, Suit.SPADES),
                new Card(13, Suit.SPADES)
        );
        HandRanking result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRanking.ROYAL_STRAIGHT_FLUSH));
    }
    @Test
    public void 숫자가_5번연속이고_모양이_같고_BACK이면_백스트레이트플러쉬이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.HEARTS),
                new Card(10, Suit.HEARTS),
                new Card(11, Suit.HEARTS),
                new Card(12, Suit.HEARTS),
                new Card(13, Suit.HEARTS)
        );
        HandRanking result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRanking.BACK_STRAIGHT_FLUSH));
    }

    @Test
    public void 숫자가_5번연속이고_BACK이면_백스트레이트이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.SPADES),
                new Card(10, Suit.DIAMONDS),
                new Card(11, Suit.SPADES),
                new Card(12, Suit.HEARTS),
                new Card(13, Suit.SPADES)
        );
        HandRanking result = evaluator.evaluate(cardList);
        assertThat(result, is(HandRanking.BACK_STRAIGHT));
    }

}


