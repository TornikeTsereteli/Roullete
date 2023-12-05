package org.example;

import org.RoulleteUtil.BetType;
import org.RoulleteUtil.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PlayerTest {
    @Test
    void testAddWinningMoneyToBalance01() {
        Player player = new Player("TestPlayer", 100);
        player.placeBet(50, BetType.ODD); // Assuming a winning bet
        player.placeBet(10, BetType.MOD3EQUALS0);
        int luckyNumber = 3;
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
        int expectedWinningMoney = 50 * 2 + 3 * 10;
        player.addWinningMoneyToBalance(luckyNumber);
        int expectedBalance = 40 + expectedWinningMoney;
        assertEquals(expectedBalance, player.getBalance());
    }
    @Test
    void testAddWinningMoneyToBalance03() {
        Player player = new Player("TestPlayer", 100);
        player.placeBet(50, BetType.ODD);
        player.placeBet(10, BetType.MOD3EQUALS0);
        player.placeBet(10,BetType.FIRSTINTERVAL);
        int luckyNumber = 5;
        int expectedWinningMoney = 50 * 2 + 3 * 10;
        player.addWinningMoneyToBalance(luckyNumber);
        int expectedBalance = 30 + expectedWinningMoney;
        assertEquals(expectedBalance, player.getBalance());
    }

    @Test
    void testAddWinningMoneyToBalance04() {
        Player player = new Player("TestPlayer", 100);
        player.placeBet(20, BetType.EVEN);
        player.placeBet(30, BetType.MOD3EQUALS1);
        int luckyNumber = 10;
        int expectedWinningMoney = 20 * 2 + 30 * 3;
        player.addWinningMoneyToBalance(luckyNumber);
        int expectedBalance = 50 + expectedWinningMoney;
        assertEquals(expectedBalance, player.getBalance());
    }

    @Test
    void testAddWinningMoneyToBalance05() {
        Player player = new Player("TestPlayer", 100);
        player.placeBet(25, BetType.ODD);
        player.placeBet(15, BetType.MOD3EQUALS0);
        player.placeBet(10, BetType.SECONDINTERVAL);
        int luckyNumber = 15;
        int expectedWinningMoney = 25 * 2 + 15 * 3 + 10 * 3;
        player.addWinningMoneyToBalance(luckyNumber);
        int expectedBalance = 50 + expectedWinningMoney;
        assertEquals(expectedBalance, player.getBalance());
    }

}
