package org.RoulleteUtil;

import java.util.List;

public class RedBlackBet implements Bet {
    private final boolean isRed;
    private final int betMoney;

    public RedBlackBet(int betMoney, boolean isRed) {
        validateBetMoney(betMoney);
        this.betMoney = betMoney;
        this.isRed = isRed;
    }

    private void validateBetMoney(int betMoney) {
        if (betMoney < 0) throw new IllegalArgumentException("bet money should not be negative!");
    }

    private static final List<Integer> luckyRedNumbers = List.of(2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35);
    private static final List<Integer> luckyBlackNumbers = List.of(1, 3, 5, 7, 9, 12, 14, 16, 18, 21, 23, 25, 30, 32, 34, 36);

    @Override
    public boolean isWinningBet(int luckyNumber) {
        if (isRed)
            return luckyRedNumbers.contains(luckyNumber);
        return luckyBlackNumbers.contains(luckyNumber);
    }

    @Override
    public int getProfit() {
        return betMoney * 2;
    }
}
