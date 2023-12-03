package org.RoulleteUtil;

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

    private void validateInterval(int interval) {
        if (interval < 1 || interval > 3) {
            throw new IllegalArgumentException("interval should be in range [1-3]!!!");
        }
    }

    @Override
    public boolean isWinningBet(int luckyNumber) {
        return luckyNumber > (interval - 1) * 12 && luckyNumber <= interval * 12;
    }

    @Override
    public int getProfit() {

        return betMoney * 3;
    }
}
