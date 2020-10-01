package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PlayerBetOutcomeTest {

  // Player Wins = Get Bet * 2
  // Player Loses = Get nothing
  // Player Pushes = Get Bet
  // Player BJ = Get Bet * 2.5

  @Test
  public void playerDeposits25IsBalanceOf25() throws Exception {
    Game game = new Game();
    game.playerDeposits(25);

    assertThat(game.playerBalance())
        .isEqualTo(25);
  }

  @Test
  public void playerWith30Bets11BalanceIs19() throws Exception {
    Game game = new Game();
    game.playerDeposits(30);

    game.playerBets(11);

    assertThat(game.playerBalance())
        .isEqualTo(30 - 11);
  }

  @Test
  public void playerWith20Bets10WhenWinsBalanceIs30() throws Exception {
    Game game = new Game();
    game.playerDeposits(20);
    game.playerBets(10);

    game.playerWins();

    assertThat(game.playerBalance())
        .isEqualTo(20 - 10 + (10 * 2));
  }

}