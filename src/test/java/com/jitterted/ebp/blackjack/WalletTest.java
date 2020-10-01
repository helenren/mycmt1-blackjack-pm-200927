package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WalletTest {

  @Test
  public void newWalletIsEmpty() throws Exception {
    Wallet wallet = new Wallet();

    assertThat(wallet.isEmpty())
        .isTrue();
  }

  // Given - When - Then
  // Arrange - Act - Assert (3 A's)
  @Test
  public void newWalletAddMoneyIsNotEmpty() throws Exception {
    Wallet wallet = new Wallet();

    wallet.addMoney(37);

    assertThat(wallet.isEmpty())
        .isFalse();
  }

  @Test
  public void newWalletIsBalanceOfZero() throws Exception {
    Wallet wallet = new Wallet();

    assertThat(wallet.balance())
        .isZero();
  }

  @Test
  public void add17BalanceIs17() throws Exception {
    Wallet wallet = new Wallet();

    wallet.addMoney(17);

    assertThat(wallet.balance())
        .isEqualTo(17);
  }

  // Y A G N I -> You Ain't Gonna Need It
  // TSTTCPW -> The Simplest Thing That Could Possibly Work

  @Test
  public void add13AndAdd21IsBalanceOf34() throws Exception {
    Wallet wallet = new Wallet();

    wallet.addMoney(13);
    wallet.addMoney(21);

    assertThat(wallet.balance())
        .isEqualTo(13 + 21);
  }

  @Test
  public void walletWith40Bet12BalanceIs28() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(40);

    wallet.bet(12);

    assertThat(wallet.balance())
        .isEqualTo(40 - 12);
  }

  @Test
  public void walletWith45Bet13AndBet12BalanceIs20() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(45);

    wallet.bet(13);
    wallet.bet(12);

    assertThat(wallet.balance())
        .isEqualTo(45 - 13 - 12);
  }

  @Test
  public void walletWith53Bet53IsEmpty() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(53);

    wallet.bet(53);

    assertThat(wallet.isEmpty())
        .isTrue();
  }

  @Test
  public void walletWith10Bet33ThrowsException() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(10);

    assertThatThrownBy(() -> {
      wallet.bet(33);
    })
        .isInstanceOf(IllegalArgumentException.class);
  }

}
