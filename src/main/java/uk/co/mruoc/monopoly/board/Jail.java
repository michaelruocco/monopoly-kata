package uk.co.mruoc.monopoly.board;

import uk.co.mruoc.monopoly.Player;

import java.util.ArrayList;
import java.util.List;

public class Jail {

    private final List<Player> players = new ArrayList<>();

    public void put(Player player) {
        players.add(player);
    }

    public boolean contains(Player player) {
        return players.contains(player);
    }

    public void remove(Player player) {
        players.remove(player);
    }

}
