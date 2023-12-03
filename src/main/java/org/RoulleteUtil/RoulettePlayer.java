package org.RoulleteUtil;

public interface RoulettePlayer {

    String getUserName();

    public int getBalance();

    void addBalance(int money);

    void placeBet(int money);

    boolean canMakeBet(int betMoney);

    void showWinningMoney(int luckyNumber);

    void addWinningMoneyToBalance(int luckyNumber);

    void clearBets();

}
