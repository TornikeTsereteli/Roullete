package org.RoulleteUtil;


import java.util.ArrayList;
import java.util.List;

public class PlayerManager {
    private final List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer() {
        if (!players.isEmpty()) {
            players.remove(0);
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addMoneyToPlayers(int amount) {
        for (Player player : players) {
            player.addBalance(amount);
        }
    }

    void notifyAllPlayers(int luckyNumber) {
        for (Player player : players) {
            player.showWinningMoney(luckyNumber);
        }
    }

}