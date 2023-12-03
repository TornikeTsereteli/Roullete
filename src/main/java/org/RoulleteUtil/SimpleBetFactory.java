package org.RoulleteUtil;

import java.util.Scanner;

public class SimpleBetFactory {

    private static Bet createBet(int betMoney, BetType betType) {
        switch (betType) {
            case RED:
                return new RedBlackBet(betMoney, true);
            case BLACK:
                return new RedBlackBet(betMoney, false);
            case EVEN:
                return new EvenOddBet(betMoney, true);
            case ODD:
                return new EvenOddBet(betMoney, false);
            case MOD3EQUALS0:
                return new ModThreeBet(betMoney, 0);
            case MOD3EQUALS1:
                return new ModThreeBet(betMoney, 1);
            case MOD3EQUALS2:
                return new ModThreeBet(betMoney, 2);
            case FIRSTINTERVAL:
                return new ThreeIntervalBet(betMoney, 1);
            case SECONDINTERVAL:
                return new ThreeIntervalBet(betMoney, 2);
            case THIRDINTERVAL:
                return new ThreeIntervalBet(betMoney, 3);
            case FIRSTHALF:
                return new HalfIntervalBet(betMoney, true);
            case SECONDHALF:
                return new HalfIntervalBet(betMoney, false);
            case NUMBER: {
                System.out.println("Please Insert your Lucky Number:");
                return new NumberBet(betMoney, new Scanner(System.in).nextInt());
            }
        }
        return null;
    }

}
