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

    private void validateUserLuckyNumber(int usersLuckyNumber) {
        if (usersLuckyNumber < 0 || usersLuckyNumber > 36) {
            throw new IllegalArgumentException("lucky number should be in range [0,36]");
        }
    }

    @Override
    public boolean isWinningBet(int luckyNumber) {
        validateBetMoney(luckyNumber);
        return isFirstHalf ? luckyNumber > 0 && luckyNumber < 19 : luckyNumber > 18 && luckyNumber < 37;
    }

    @Override
    public int getProfit() {
        return betMoney * 2;
    }

}
