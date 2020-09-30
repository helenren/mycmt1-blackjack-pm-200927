package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CardRankValueTest {

  private static final Suit DUMMY_SUIT = Suit.HEARTS;


  @Test
  public void withNumberCardHasNumericValueOfTheNumber() throws Exception {
    Card card = createCardRankOf("7");

    assertThat(card.rankValue())
        .isEqualTo(7);
  }

  @Test
  public void withValueOfQueenHasNumericValueOf10() throws Exception {
    Card card = createCardRankOf("Q");

    assertThat(card.rankValue())
        .isEqualTo(10);
  }

  @Test
  public void withAceHasNumericValueOf1() throws Exception {
    Card card = createCardRankOf("A");

    assertThat(card.rankValue())
        .isEqualTo(1);
  }

  private Card createCardRankOf(String rankValue) {
    return new Card(DUMMY_SUIT, Rank.of(rankValue));
  }

}