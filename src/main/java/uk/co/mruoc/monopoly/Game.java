package uk.co.mruoc.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final int TOTAL_ROUNDS = 20;

    private final List<Round> rounds = new ArrayList(TOTAL_ROUNDS);
    private final Players players = new Players();

    public Game(int numberOfPlayers) {
        players.validate(numberOfPlayers);
        players.generate(numberOfPlayers);
    }

    public void play() {
        for(int r = 0; r < TOTAL_ROUNDS; r++) {
            play(new Round());
        }
    }

    public int getNumberOfPlayers() {
        return players.count();
    }

    public boolean playerExists(String name) {
        return players.exists(name);
    }

    public Player getPlayer(int index) {
        return players.getPlayer(index);
    }

    private void play(Round round) {
        players.play(round);
        rounds.add(round);
    }

    public int getNumberOfRounds() {
        return rounds.size();
    }

    public boolean playerOrderIsSameForEveryRound() {
        for(Round round : rounds)
            if (round.playersMatch(players.getList()))
                return true;
        return false;
    }

}
