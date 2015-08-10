package uk.co.mruoc.monopoly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Players {

    private static final String[] NAMES = { "Horse" , "Car", "Boat", "Dog", "Thimble", "Boot", "Hat", "Wheelbarrow" };
    private static final int MAX_PLAYERS = NAMES.length;

    private final PlayersValidator validator = new PlayersValidator(Players.MAX_PLAYERS);
    private final List<Player> players = new ArrayList();

    public void validate(int numberOfPlayers) {
        validator.validate(numberOfPlayers);
    }

    public void generate(int numberOfPlayers) {
        for(int p = 0; p < numberOfPlayers; p++)
            players.add(new Player(NAMES[p]));
        Collections.shuffle(players);
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public int count() {
        return players.size();
    }

    public boolean exists(String name) {
        for(Player player : players)
            if (player.nameIs(name))
                return true;
        return false;
    }

    public void play(Round round) {
        for(Player player : players) {
            round.takeTurn(player);
            player.addRound(round);
        }
    }

    public List<Player> getList() {
        return players;
    }

}
