package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

  private static final Suit DUMMY_SUIT = Suit.CLUBS;

  @Test
  public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
    Hand hand = createHand("A", "9");

    assertThat(hand.valueEqualTo(11 + 9))
        .isTrue();
  }

  @Test
  public void handWithOneAceAndOtherCardsValuedAt10IsValuedAt11() throws Exception {
    Hand hand = createHand("A", "10");

    assertThat(hand.valueEqualTo(11 + 10))
        .isTrue();
  }

  @Test
  public void handWithOneAceAndOtherCardsEqualTo11IsValuedAt1() throws Exception {
    Hand hand = createHand("A", "8", "3");

    assertThat(hand.valueEqualTo(1 + 8 + 3))
        .isTrue();
  }

  @Test
  public void handWithOneAceAndOtherCardsEqualTo12IsValuedAt1() throws Exception {
    Hand hand = createHand("A", "7", "5");

    assertThat(hand.valueEqualTo(1 + 7 + 5))
        .isTrue();
  }

  private Hand createHand(String... ranks) {
    List<Card> cards = new ArrayList<>();
    for (String rank : ranks) {
      cards.add(new Card(DUMMY_SUIT, rank));
    }
    return new Hand(cards);
  }

}
