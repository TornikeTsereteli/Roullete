package org.RoulleteUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RouletteGame {

    private final Roulette roulette;
    private final List<Player> players = new LinkedList<>();
    private final BetManager betManager;

    public RouletteGame(Roulette roulette, BetManager betManager) {
        this.roulette = roulette;
        this.betManager = betManager;
    }

    void notifyAllPlayers(int luckyNumber) {
        for (Player player : players) {
            player.addWinningMoneyToBalance(luckyNumber);
            player.showWinningMoney(luckyNumber);
        }
    }

    void startGame() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Game Starts!!!");
        System.out.println("Enter how many player will participate in roulette game:");

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            Player player = new Player("player" + i);  // deposit should be more than zero
            players.add(player);
        }
        while (true) {

            for (Player p : players) {
                System.out.println(p.getUserName() + " add money to your balance if you wish:");
                int balance = scanner.nextInt();
                while (balance <= 0) {
                    System.out.println("Dealer: You can't deposit negative NUmber, please insert positive integer!");
                    balance = scanner.nextInt();
                }
                p.addBalance(balance);
            }

            for (Player player : players) {
                betManager.makeBets(player);
            }

            Thread.sleep(1000);
            System.out.println("roullete spins....");
            Thread.sleep(1000);
            roulette.spinWheel();
            int luckyNumber = roulette.getNumber();
            System.out.println("Lucky Number is " + luckyNumber);
            notifyAllPlayers(luckyNumber);

            System.out.println("Dealer: Players!, Do you you wish to Continue Game?, if yes input Y else input any character");
            String s = scanner.next();
            scanner.nextLine();

            for (Player p : players) {
                p.clearBets();
            }
            if (!s.equals("Y")) {
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RouletteGame rouletteGame = new RouletteGame(new EuropeanRoulette(), new ConcreteBetManager());
        rouletteGame.startGame();

    }
}
