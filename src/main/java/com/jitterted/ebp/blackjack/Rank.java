package com.jitterted.ebp.blackjack;

public class Rank {
  private final String rankString;

  public Rank(String rankString) {
    this.rankString = rankString;
  }

  public static Rank of(String rankString) {
    return new Rank(rankString);
  }

  public String asString() {
    return rankString;
  }
}
