package org.RoulleteUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Player {
    private List<Bet> bets = new LinkedList<>();
    private final String userName;
    private int balance;
    private int bettedMoney = 0;

    public String getUserName() {
        return userName;
    }

    public Player(String userName) {
        this.userName = userName;
    }

    public Player(String userName, int balance) {
        validateBalance(balance);
        this.userName = userName;
        this.balance = balance;
    }


    private void validateBetMoney(int betMoney) {
        if (betMoney <= 0) {
            throw new IllegalArgumentException("bet Money should be positive number!!");
        }
    }


    private void validateBalance(int balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("balance should be more than or equal to 0");
        }
    }

    public void addBalance(int money) {
        validateBetMoney(money);
        balance += money;
    }

    public void placeBet(int betMoney, BetType betType) {
        validateBalance(betMoney);
        bettedMoney += betMoney;
        balance -= betMoney;
        bets.add(createBet(betMoney, betType));
    }

    boolean canMakeBet(int betMoney) {
        validateBetMoney(betMoney);
        return betMoney <= balance;
    }

    private Bet createBet(int betMoney, BetType betType) {
        validateBetMoney(betMoney);
        switch (betType) {
            case RED:
                return new RedBlackBet(betMoney, true);
            case BLACK:
                return new RedBlackBet(betMoney, false);
            case EVEN:
                return new EvenOddBet(betMoney, true);
            case ODD:
                return new EvenOddBet(betMoney, false);
            case MOD3EQUALS0:
                return new ModThreeBet(betMoney, 0);
            case MOD3EQUALS1:
                return new ModThreeBet(betMoney, 1);
            case MOD3EQUALS2:
                return new ModThreeBet(betMoney, 2);
            case FIRSTINTERVAL:
                return new ThreeIntervalBet(betMoney, 1);
            case SECONDINTERVAL:
                return new ThreeIntervalBet(betMoney, 2);
            case THIRDINTERVAL:
                return new ThreeIntervalBet(betMoney, 3);
            case FIRSTHALF:
                return new HalfIntervalBet(betMoney, true);
            case SECONDHALF:
                return new HalfIntervalBet(betMoney, false);
            case NUMBER: {
                System.out.println("Please Insert your Lucky Number:");
                Scanner scanner = new Scanner(System.in);
                int luckyNumber = scanner.nextInt();
                while (luckyNumber < 0 || luckyNumber > 37){
                    System.out.println("your lucky number should be in range [0-36] please insert again:");
                    luckyNumber = scanner.nextInt();
                }
                return new NumberBet(betMoney,luckyNumber);
            }
        }
        return null;
    }


    private int getWinningMoney(int luckyNumber) {
        validateLuckyNumber(luckyNumber);
        return bets.stream().filter(x -> x.isWinningBet(luckyNumber))
                .mapToInt(Bet::getProfit).sum();
    }


    public void showWinningMoney(int luckyNumber) {
        int winningMoney = (getWinningMoney(luckyNumber) - bettedMoney);
        if (winningMoney >= 0)
            System.out.println(userName + " have Won " + winningMoney + " Gel and his balance is " + balance + " GEL");
        else
            System.out.println(userName + " have lost " + winningMoney + " Gel and his balance is " + balance + "GEL");

    }
    private void validateLuckyNumber(int luckyNumber){
        if(luckyNumber < 0 || luckyNumber > 36){
            throw new IllegalArgumentException("lucky number should be in the range [0-36]");
        }
    }

    public void addWinningMoneyToBalance(int luckyNumber) {
        validateBetMoney(luckyNumber);
        addBalance(getWinningMoney(luckyNumber));
    }

    public int getBalance() {
        return balance;
    }

    public void clearBets() {
        bets = new LinkedList<>();
        bettedMoney = 0;
    }
}
