package uk.co.mruoc.monopoly;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Game {

    private static final String[] PLAYER_NAMES = { "Horse" , "Car", "Boat", "Dog", "Thimble", "Boot", "Hat", "Wheelbarrow" };

    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = PLAYER_NAMES.length;

    private static final String MIN_PLAYERS_MESSAGE = "cannot create a game with less than " + MIN_PLAYERS + " players";
    private static final String MAX_PLAYERS_MESSAGE = "cannot create a game with more than " + MAX_PLAYERS + " players";

    private static final int TOTAL_ROUNDS = 20;

    private final List<Player> players = new ArrayList();
    private final List<Round> rounds = new ArrayList(TOTAL_ROUNDS);

    public Game(int numberOfPlayers) {
        validate(numberOfPlayers);
        generatePlayers(numberOfPlayers);
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public Player getPlayer(int p) {
        return players.get(p);
    }

    public boolean playerExists(String name) {
        for(Player player : players) {
            if (player.nameIs(name)) {
                return true;
            }
        }
        return false;
    }

    public void play() {
        for(int r = 0; r < TOTAL_ROUNDS; r++) {
            play(new Round());
        }
    }

    private void play(Round round) {
        for(Player player : players) {
            round.takeTurn(player);
            player.addRound(round);
        }
        rounds.add(round);
    }

    public int getNumberOfRounds() {
        return rounds.size();
    }

    public boolean playerOrderIsSameForEveryRound() {
        for(Round round : rounds) {
            if (round.playersMatch(players)) {
                return true;
            }
        }
        return false;
    }

    private void validate(int numberOfPlayers) {
        if (numberOfPlayers < MIN_PLAYERS)
            throw new MonopolyException(MIN_PLAYERS_MESSAGE);
        if (numberOfPlayers > MAX_PLAYERS)
            throw new MonopolyException(MAX_PLAYERS_MESSAGE);
    }

    private void generatePlayers(int numberOfPlayers) {
        for(int p = 0; p < numberOfPlayers; p++)
            players.add(new Player(PLAYER_NAMES[p]));
        Collections.shuffle(players);
    }

}
