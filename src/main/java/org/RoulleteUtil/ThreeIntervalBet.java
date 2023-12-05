package org.RoulleteUtil;

/**
  this class represents such bets
  win if the number is in range [1-12]  example: Bet firstIntervalBet = new ThreeInterval(50,1);
  win if the number is in range [13-24] example: Bet secondIntervalBet = new ThreeInterval(50,2);
  win if the number is in range [25-36] example: Bet thirdIntervalBet = new ThreeInterval(50,3);

 */
public class ThreeIntervalBet implements Bet {
    private final int interval;
    private final int betMoney;

    public ThreeIntervalBet(int betMoney, int interval) {
        validateBetMoney(betMoney);
        validateInterval(interval);
        this.betMoney = betMoney;
        this.interval = interval;
    }

    private void validateBetMoney(int betMoney) {
        if (betMoney < 0) throw new IllegalArgumentException("bet money should not be negative!");
    }

    private void validateLuckyNumber(int luckyNumber) {
        if (luckyNumber < 0 || luckyNumber > 36) {
            throw new IllegalArgumentException("lucky number should be in range [0-36]");
        }
    }

    private void validateInterval(int interval) {
        if (interval < 1 || interval > 3) {
            throw new IllegalArgumentException("interval should be in range [1-3]!!!");
        }
    }

    @Override
    public boolean isWinningBet(int luckyNumber) {
        validateLuckyNumber(luckyNumber);
        return luckyNumber > (interval - 1) * 12 && luckyNumber <= interval * 12;
    }

    @Override
    public int getProfit() {

        return betMoney * 3;
    }
}
