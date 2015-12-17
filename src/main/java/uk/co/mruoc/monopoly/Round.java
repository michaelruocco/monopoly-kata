package uk.co.mruoc.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Round {

    private final List<Player> roundPlayers = new ArrayList<>();

    public void takeTurn(Player player) {
        roundPlayers.add(player);
        player.addRound(this);
    }

    public boolean playersMatch(List<Player> players) {
        return roundPlayers.equals(players);
    }

}
