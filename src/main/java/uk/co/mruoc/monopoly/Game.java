package uk.co.mruoc.monopoly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private static final int TOTAL_ROUNDS = 20;

    private final List<Round> rounds = new ArrayList(TOTAL_ROUNDS);
    private final Board board = new Board();
    private final Players players = new Players();
    private final int totalTurns;

    private int nextPlayerIndex;
    private Round currentRound = new Round();
    private Random random = new Random();

    public Game(int numberOfPlayers) {
        players.validate(numberOfPlayers);
        players.generate(numberOfPlayers);
        totalTurns = numberOfPlayers * TOTAL_ROUNDS;
    }

    public void play() {
        for(int r = 0; r < totalTurns; r++) {
            nextTurn(generateRoll());
        }
    }

    public void playFullGame() {
        for(int r = 0; r < totalTurns; r++) {
            nextTurn(2);
        }
    }

    public void nextTurn(int roll) {
        Player player = players.getList().get(nextPlayerIndex);
        board.movePlayer(roll, player);
        currentRound.takeTurn(player);
        player.addRound(currentRound);

        if (players.allOtherPlayersHaveLost(player))
            return;

        nextPlayerIndex++;
        if (nextPlayerIndex >= players.count()) {
            nextPlayerIndex = 0;
            rounds.add(currentRound);
            currentRound = new Round();
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

    public int getNumberOfRounds() {
        return rounds.size();
    }

    public boolean playerOrderIsSameForEveryRound() {
        for(Round round : rounds)
            if (round.playersMatch(players.getList()))
                return true;
        return false;
    }

    public Player getWinner() {
        return players.getWinner();
    }

    private int generateRoll() {
        return random.nextInt(12 - 1 + 1) + 1;
    }

}
