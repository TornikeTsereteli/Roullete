package org.RoulleteUtil;

import java.util.Scanner;

/**
   this class represents players bet Manager strategy
 */

public class ConcreteBetManager implements BetManager {
    public static final BetType[] POSSIBLE_BETS = BetType.values();

    public void makeBets(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(player.getUserName() + " make your bets:");

        while (true) {
            if (player.getBalance() <= 0) {
                System.out.println("Dealer: sorry you can't make another bet :(, your balance is ZERO");
                break;
            }
            showBets();
            System.out.println("insert your chosen bet:");
            int bet = scanner.nextInt();

            while (bet < -1 || bet > 13) {
                System.out.println("sorry you can't bet on " + bet + "th, choose number from -1 to " + 13 + ":");
                bet = scanner.nextInt();
            }
            if (bet == 13 || bet == -1) {
                break;
            }
            System.out.println("please also insert the desirable amount of money to bet:");
            int betMoney = scanner.nextInt();


            while (betMoney<=0 || !player.canMakeBet(betMoney)) {
                System.out.println("Dealer: you can't bet negative or zero amount of money or sorry you can't make a bet :) your balance is " + player.getBalance());
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
        System.out.println("13 | -1 -> FINISHBETS");

    }

}
