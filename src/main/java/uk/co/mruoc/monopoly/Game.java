package uk.co.mruoc.monopoly;

import lombok.RequiredArgsConstructor;
import uk.co.mruoc.monopoly.players.Players;

import java.util.Collection;

@RequiredArgsConstructor
public class Game {

    private final Players players;

    public Game(Collection<String> playerNames) {
        this(new Players(playerNames));
    }

    public void start() {
        // intentionally blank
    }

    public boolean hasPlayer(String name) {
        return players.hasName(name);
    }

    public boolean hasFirstPlayer(String name) {
        return players.hasFirstName(name);
    }

}
