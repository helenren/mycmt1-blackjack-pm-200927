package com.jitterted.ebp.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.fusesource.jansi.Ansi.ansi;

public class Hand {
  private final List<Card> cards;

  public Hand() {
    this.cards = new ArrayList<>();
  }

  public Hand(List<Card> cards) {
    this.cards = cards;
  }

  // GOAL: changed to be more "domain specific"
  public void add(Card card) {
    cards.add(card);
  }

  void displayHand() {
    System.out.println(cards.stream()
                            .map(Card::display)
                            .collect(Collectors.joining(
                                ansi().cursorUp(6).cursorRight(1).toString())));
  }

  void displayFirstCard() {
    System.out.println(cards.get(0).display());
  }

  boolean valueEqualTo(int value) {
    return value() == value;
  }

  private int value() {
    int handValue = cards
        .stream()
        .mapToInt(Card::rankValue)
        .sum();

    // does the hand contain at least 1 Ace?
    boolean hasAce = cards
        .stream()
        .anyMatch(card -> card.rankValue() == 1);

    // if the total hand value <= 11, then count the Ace as 11 by adding 10
    if (hasAce && handValue <= 11) {
      handValue += 10;
    }

    return handValue;
  }

  boolean isBusted() {
    return value() > 21;
  }

  boolean isValueLessThanOrEqualTo(int value) {
    return value() <= value;
  }

  public boolean beats(Hand hand) {
    return hand.value() < value();
  }

  public boolean pushes(Hand hand) {
    return hand.value() == value();
  }

  void displayValue() {
    System.out.println(" (" + value() + ")");
  }
}
