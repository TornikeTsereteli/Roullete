package org.RoulleteUtil;

import java.util.*;

public class RouletteGame {

    private final Roulette roulette;
    private final List<Player> players = new LinkedList<>();
    private final BetManager betManager;

    public RouletteGame(Roulette roulette, BetManager betManager) {
        this.roulette = roulette;
        this.betManager = betManager;

    }

    private static void validateLuckyNumber(int luckyNumber) {
        if (luckyNumber < 0 || luckyNumber > 36) {
            throw new IllegalArgumentException("lucky number must be in range [0-36]");
        }
    }

    void notifyAllPlayers(int luckyNumber) {
        validateLuckyNumber(luckyNumber);
        for (Player player : players) {
            player.addWinningMoneyToBalance(luckyNumber);
            player.showWinningMoney(luckyNumber);
        }
    }

    private void addPlayers(Scanner scanner) {
        System.out.println("Enter how many player will participate in roulette game:");
        int n = scanner.nextInt();  // in our case n = 1 will be inserted from the console
        while (n <= 0) {
            System.out.println("number of players should be ppositive number, please insert again:");
            n = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            Player player = new Player("player" + i);  // deposit should be more than zero
            players.add(player);
        }
    }

    private void addBalanceToPlayers(Scanner scanner) {

        for (Player p : players) {
            System.out.println(p.getUserName() + " add money to your balance if you wish:");
            int balance = scanner.nextInt();
            while (balance <= 0) {
                System.out.println("Dealer: You can't deposit negative NUmber, please insert positive integer!");
                balance = scanner.nextInt();
            }
            p.addBalance(balance);
        }

    }

    void startGame() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Game Starts!!!");
        addPlayers(scanner);
        while (true) {
            addBalanceToPlayers(scanner);
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
