package org.RoulleteUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BetParser {

    public static List<Bet> parseBets(String input) {
        List<Bet> bets = new ArrayList<>();

        // Regular expression pattern to match "(type,amount)"
        Pattern pattern = Pattern.compile("\\(([^,]+),(\\d+)\\)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String type = matcher.group(1).trim();
            int amount = Integer.parseInt(matcher.group(2).trim());

            Bet bet = createBet(type, amount);
            if (bet != null) {
                bets.add(bet);
            }
        }

        return bets;
    }

    private static Bet createBet(String type, int amount) {
        // Implement logic to create specific Bet objects based on the type
        switch (type.toLowerCase()) {
            case "red":
                return new RedBlackBet(amount, true);
            case "black":
                return new RedBlackBet(amount, false);
            case "even":
                return new EvenOddBet(amount, true);
            case "odd":
                return new EvenOddBet(amount, false);
            case "firsthalf":
                return new HalfIntervalBet(amount, true);
            case "secondhalf":
                return new HalfIntervalBet(amount, false);
            case "mod3equals0":
                return new ModThreeBet(amount, 0);
            case "mod3equals1":
                return new ModThreeBet(amount, 1);
            case "mod3equals2":
                return new ModThreeBet(amount, 2);
            case "firstinterval":
                return new ThreeIntervalBet(amount, 1);
            // Add more cases for other bet types
            case "secondinterval":
                return new ThreeIntervalBet(amount, 2);
            case "thirdinterval":
                return new ThreeIntervalBet(amount, 3);

            default:
                // Unknown bet type, handle accordingly
                System.out.println("Unknown bet type: " + type);
                return null;
        }
    }

    public static void main(String[] args) {
        String input = "(Red,12), (11,23), (31,100), (Odd,12)";
        List<Bet> bets = parseBets(input);

        // Print the parsed bets
        for (Bet bet : bets) {
            System.out.println("Type: " + bet.getClass().getSimpleName() + ", Amount: " + bet.getProfit());
        }
    }
}
