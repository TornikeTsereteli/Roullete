package org.example;

import org.RoulleteUtil.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class BetTest {
    @Test
    void evenOddBetWinningTest() {
        Bet evenBet = new EvenOddBet(10, true);
        Bet oddBet = new EvenOddBet(15, false);

        assertTrue(evenBet.isWinningBet(6));
        assertFalse(evenBet.isWinningBet(7));
        assertFalse(evenBet.isWinningBet(0));

        assertTrue(oddBet.isWinningBet(7));
        assertFalse(oddBet.isWinningBet(8));
        assertFalse(evenBet.isWinningBet(0));

        assertEquals(20, evenBet.getProfit());
        assertEquals(30, oddBet.getProfit());
    }

    @Test
    void halfIntervalBetWinningTest() {
        Bet firstHalfBet = new HalfIntervalBet(20, true);
        Bet secondHalfBet = new HalfIntervalBet(25, false);
        // first half Bet tests
        assertTrue(firstHalfBet.isWinningBet(1));
        assertTrue(firstHalfBet.isWinningBet(18));
        assertTrue(firstHalfBet.isWinningBet(15));

        assertFalse(firstHalfBet.isWinningBet(20));
        assertFalse(firstHalfBet.isWinningBet(0));
        //second half Bet tests


        assertTrue(secondHalfBet.isWinningBet(36));
        assertTrue(secondHalfBet.isWinningBet(25));
        assertFalse(secondHalfBet.isWinningBet(18));

        assertEquals(40, firstHalfBet.getProfit());
        assertEquals(50, secondHalfBet.getProfit());
    }

    @Test
    void modThreeBetWinningTest() {
        Bet mod0Bet = new ModThreeBet(30, 0);
        Bet mod1Bet = new ModThreeBet(25, 1);
        Bet mod2Bet = new ModThreeBet(15, 2);

        // mod 0 tests
        assertTrue(mod0Bet.isWinningBet(12));
        assertTrue(mod0Bet.isWinningBet(6));
        assertFalse(mod0Bet.isWinningBet(7));
        assertFalse(mod0Bet.isWinningBet(0));

        // mod 1 tests
        assertFalse(mod1Bet.isWinningBet(12));
        assertTrue(mod1Bet.isWinningBet(25));
        assertFalse(mod1Bet.isWinningBet(0));


        // mod2 tests
        assertFalse(mod2Bet.isWinningBet(25));
        assertTrue(mod2Bet.isWinningBet(8));
        assertFalse(mod2Bet.isWinningBet(9));
        assertFalse(mod2Bet.isWinningBet(0));

        // profit tests
        assertEquals(90, mod0Bet.getProfit());
        assertEquals(75, mod1Bet.getProfit());
        assertEquals(45, mod2Bet.getProfit());
    }

    @Test
    void numberBetWinningTest() {
        Bet numberBet = new NumberBet(50, 18);


        assertTrue(numberBet.isWinningBet(18));
        assertFalse(numberBet.isWinningBet(20));
        assertThrows(IllegalArgumentException.class,()-> numberBet.isWinningBet(37));

        assertEquals(1800, numberBet.getProfit());
    }

    @Test
    void redBlackBetWinningTest() {
        Bet redBet = new RedBlackBet(30, true);
        Bet blackBet = new RedBlackBet(25, false);

        assertTrue(redBet.isWinningBet(8));
        assertFalse(redBet.isWinningBet(7));
        assertFalse(redBet.isWinningBet(0));

        assertTrue(blackBet.isWinningBet(14));
        assertFalse(blackBet.isWinningBet(17));
        assertFalse(blackBet.isWinningBet(0));

        assertEquals(60, redBet.getProfit());
        assertEquals(50, blackBet.getProfit());
    }

    @Test
    void threeIntervalBetTest() {
        Bet firstIntervalBet = new ThreeIntervalBet(13, 1);
        Bet secondIntervalBet = new ThreeIntervalBet(50, 2);
        Bet thirdIntervalBet = new ThreeIntervalBet(32, 3);

        // first interval Bet
        assertTrue(firstIntervalBet.isWinningBet(1));
        assertTrue(firstIntervalBet.isWinningBet(12));
        assertTrue(firstIntervalBet.isWinningBet(4));
        assertFalse(firstIntervalBet.isWinningBet(0));
        assertFalse(firstIntervalBet.isWinningBet(13));

        // second interval bet
        assertTrue(secondIntervalBet.isWinningBet(13));
        assertTrue(secondIntervalBet.isWinningBet(24));
        assertTrue(secondIntervalBet.isWinningBet(15));
        assertFalse(secondIntervalBet.isWinningBet(12));
        assertFalse(secondIntervalBet.isWinningBet(25));
        assertFalse(secondIntervalBet.isWinningBet(11));

        //third interval test
        assertTrue(thirdIntervalBet.isWinningBet(25));
        assertTrue(thirdIntervalBet.isWinningBet(36));
        assertTrue(thirdIntervalBet.isWinningBet(27));
        assertFalse(thirdIntervalBet.isWinningBet(24));
        assertFalse(thirdIntervalBet.isWinningBet(23));
        assertFalse(thirdIntervalBet.isWinningBet(0));

        // profit tests
        assertEquals(96, thirdIntervalBet.getProfit());
        assertEquals(150, secondIntervalBet.getProfit());


    }

}
