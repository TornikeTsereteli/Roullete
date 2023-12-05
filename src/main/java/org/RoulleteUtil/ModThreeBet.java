package org.RoulleteUtil;

/**
   this class represents such bets:
      win money if lucky number is divided 3 reminder is 0 or 1 or 2
   example of lucky number mod 3 equals 0:
   Bet mod3Equals0Bet = new ModThreeBet(4,0)
   for mod 3 == 1:
   Bet mod3Equals1Bet = new ModThreeBet(4,1)
   for mod 3 == 2
   Bet mod3Equals2Bet = new ModThreeBet(4,0)
 */
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
