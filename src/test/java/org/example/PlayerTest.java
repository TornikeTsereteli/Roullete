package org.example;

import org.RoulleteUtil.BetType;
import org.RoulleteUtil.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PlayerTest {
    @Test
    void testShowWinningMoney() {

    }

    @Test
    void testAddWinningMoneyToBalance01() {
        Player player = new Player("TestPlayer", 100);
        player.placeBet(50, BetType.ODD); // Assuming a winning bet
        player.placeBet(10, BetType.MOD3EQUALS0);
        int luckyNumber = 3;
        // Assuming the bet type is ODD, which wins with luckyNumber=3
        int expectedWinningMoney = 50 * 2 + 3 * 10; // Bet amount * winning multiplier
        player.addWinningMoneyToBalance(luckyNumber);
        int expectedBalance = 40 + expectedWinningMoney;

        assertEquals(expectedBalance, player.getBalance());
    }

    @Test
    void testAddWinningMoneyToBalance02() {
        Player player = new Player("TestPlayer", 100);
        player.placeBet(50, BetType.ODD); // Assuming a winning bet
        player.placeBet(10, BetType.MOD3EQUALS0);
        int luckyNumber = 3;
        // Assuming the bet type is ODD, which wins with luckyNumber=3
        int expectedWinningMoney = 50 * 2 + 3 * 10; // Bet amount * winning multiplier
        player.addWinningMoneyToBalance(luckyNumber);
        int expectedBalance = 40 + expectedWinningMoney;

        assertEquals(expectedBalance, player.getBalance());
    }

}
