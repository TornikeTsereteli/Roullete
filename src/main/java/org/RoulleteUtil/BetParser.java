package org.RoulleteUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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


            BetType betType = BetType.fromString(type);
            Bet bet = SimpleBetFactory.createBet(amount, betType);
            if (bet != null) {
                bets.add(bet);
            }
        }
        return bets;
    }


    public static void main(String[] args) {
        String input = "(red,12),(mod3Equals1,23),(Number ,100),(Odd,12)";
        List<Bet> bets = parseBets(input);

        // Print the parsed bets
        for (Bet bet : bets) {
            System.out.println("Type: " + bet.getClass().getSimpleName() + ", Amount: " + bet.getProfit());
        }
    }
}
