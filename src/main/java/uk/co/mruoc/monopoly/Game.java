package uk.co.mruoc.monopoly;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Game {

    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 8;

    private final Collection<String> players;

    public Game(Collection<String> players) {
        this.players = randomize(players);
    }

    public void start() {
        if (players.size() < 2) {
            throw new LessThanMinPlayersException(players.size(), MIN_PLAYERS);
        }
        if (players.size() > 8) {
            throw new GreaterThanMaxPlayersException(players.size(), MAX_PLAYERS);
        }
        Collections.shuffle(new ArrayList<>(players));
    }

    public boolean hasPlayer(String name) {
        return players.contains(name);
    }

    public boolean hasFirstPlayer(String name) {
        return players.stream().findFirst()
                .map(firstPlayer -> firstPlayer.equals(name))
                .orElse(false);
    }

    private static Collection<String> randomize(Collection<String> players) {
        List<String> randomizedPlayers = new ArrayList<>(players);
        Collections.shuffle(randomizedPlayers);
        return Collections.unmodifiableList(randomizedPlayers);
    }

}
