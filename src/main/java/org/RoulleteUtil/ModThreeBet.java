package org.RoulleteUtil;

public class ModThreeBet implements Bet {
    private final int mod;
    private final int betMoney;

    public ModThreeBet(int betMoney, int mod) {
        validateBetMoney(betMoney);
        validateMod(mod);

        this.betMoney = betMoney;
        this.mod = mod;
    }

    private void validateBetMoney(int betMoney) {
        if (betMoney < 0) throw new IllegalArgumentException("bet money should not be negative!");
    }

    private void validateMod(int mod) {
        if (mod > 2 || mod < 0) {
            throw new IllegalArgumentException("mod should be 0 1 2!!! ");
        }
    }

    @Override
    public boolean isWinningBet(int luckyNumber) {
        return luckyNumber % 3 == mod && luckyNumber != 0;
    }

    @Override
    public int getProfit() {
        return betMoney * 3;
    }
}
