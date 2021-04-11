package uk.co.mruoc.monopoly;

import lombok.RequiredArgsConstructor;
import uk.co.mruoc.monopoly.board.Board;
import uk.co.mruoc.monopoly.players.Players;

import java.util.Arrays;
import java.util.Collection;

@RequiredArgsConstructor
public class Game {

    private final Players players;
    private final Board board;

    public Game(String... playerNames) {
        this(Arrays.asList(playerNames));
    }

    public Game(Collection<String> playerNames) {
        this(new Players(playerNames));
    }

    public Game(Players players) {
        this(players, new Board());
    }

    public void start() {
        players.stream().forEach(board::addPlayer);
    }

    public boolean hasPlayer(String name) {
        return players.contains(name);
    }

    public boolean isNextPlayer(String name) {
        return players.isNext(name);
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public void setPlayerLocation(String name, int location) {
        board.placePlayer(name, location);
    }

    public void playTurn(String name, int rolled) {
        board.movePlayer(name, rolled);
    }

    public int getPlayerLocation(String name) {
        return board.getLocation(name);
    }

}
