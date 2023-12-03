package org.RoulleteUtil;

import java.util.Scanner;

public class ConcreteBetManager implements BetManager {
    public static final BetType[] POSSIBLE_BETS = BetType.values();

    public void makeBets(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(player.getUserName() + " make your bets:\nDealer: how many bets do you wanna make:");
        int numberOfBets = scanner.nextInt();

        for (int i = 0; i < numberOfBets; i++) {
            if (player.getBalance() <= 0) {
                System.out.println("Dealer: sorry you can't make another bet :(, your balance is ZERO");
                break;
            }
            showBets();
            System.out.println("insert your chosen bet:");
            int bet = scanner.nextInt();
            while (bet < 0 || bet >= POSSIBLE_BETS.length) {
                System.out.println("sorry you can't bet on " + bet + "th, choose number from 0 to " + (POSSIBLE_BETS.length - 1) + ":");
                bet = scanner.nextInt();
            }
            System.out.println("please also insert the desirable amount of money to bet:");
            int betMoney = scanner.nextInt();

            while (!player.canMakeBet(betMoney)) {
                System.out.println("Dealer: sorry you can't make a bet :) your balance is " + player.getBalance());
                System.out.println("Dealer: please bet money again!");
                betMoney = scanner.nextInt();
            }
            player.placeBet(betMoney, POSSIBLE_BETS[bet]);
            System.out.println("successfully placed a bet");
        }
    }

    private void showBets() {
        System.out.println("Here are possible bets:");
        for (int i = 0; i < POSSIBLE_BETS.length; i++) {
            System.out.println(i + " -> " + POSSIBLE_BETS[i]);
        }
    }

}