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

    private void validateUserLuckyNumber(int usersLuckyNumber) {
        if (usersLuckyNumber < 0 || usersLuckyNumber > 36) {
            throw new IllegalArgumentException("lucky number should be in range [0,36]");
        }
    }

    @Override
    public boolean isWinningBet(int luckyNumber) {
        validateUserLuckyNumber(luckyNumber);
        if (luckyNumber == 0) return false;
        return isEven ? luckyNumber % 2 == 0 : luckyNumber % 2 == 1;
    }

    @Override
    public int getProfit() {
        return betMoney * 2;
    }
}
