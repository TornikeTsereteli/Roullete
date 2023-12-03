package org.RoulleteUtil;

public class HalfIntervalBet implements Bet {
    private final boolean isFirstHalf;
    private final int betMoney;

    public HalfIntervalBet(int betMoney, boolean isFirstHalf) {
        validateBetMoney(betMoney);
        this.betMoney = betMoney;
        this.isFirstHalf = isFirstHalf;
    }

    private void validateBetMoney(int betMoney) {
        if (betMoney < 0) throw new IllegalArgumentException("bet money should not be negative!");
    }

    @Override
    public boolean isWinningBet(int luckyNumber) {
        if (isFirstHalf)
            return luckyNumber > 0 && luckyNumber < 19;
        else
            return luckyNumber > 18 && luckyNumber < 37;
    }

    @Override
    public int getProfit() {
        return betMoney * 2;
    }

}
