package org.RoulleteUtil;

public class EvenOddBet implements Bet {
    private final boolean isEven;
    private final int betMoney;

    public EvenOddBet(int betMoney, boolean isEven) {
        validateBetMoney(betMoney);
        this.betMoney = betMoney;
        this.isEven = isEven;
    }

    private void validateBetMoney(int betMoney) {
        if (betMoney < 0) throw new IllegalArgumentException("bet money should not be negative!");
    }

    @Override
    public boolean isWinningBet(int luckyNumber) {
        if (isEven)
            return luckyNumber % 2 == 0;
        return luckyNumber % 2 == 1;
    }

    @Override
    public int getProfit() {
        return betMoney * 2;
    }
}
