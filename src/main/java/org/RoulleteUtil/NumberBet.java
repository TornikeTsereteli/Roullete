package org.RoulleteUtil;

/**
   this class represent number bet:
   example:
      Bet number3Bet = new NumberBet(20,3);
 */
public class NumberBet implements Bet {
    private final int usersLuckyNumber;
    private final int betMoney;

    public NumberBet(int betMoney, int usersLuckyNumber) {
        validateBetMoney(betMoney);
        validateUserLuckyNumber(usersLuckyNumber);
        this.betMoney = betMoney;
        this.usersLuckyNumber = usersLuckyNumber;
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
        return luckyNumber == usersLuckyNumber;
    }

    @Override
    public int getProfit() {
        return betMoney * 36;
    }
}
