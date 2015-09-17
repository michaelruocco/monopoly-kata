package uk.co.mruoc.monopoly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private static final int TOTAL_ROUNDS = 20;

    private final List<Round> rounds = new ArrayList(TOTAL_ROUNDS);
    private final Board board = new Board();
    private final Players players = new Players();

    private int nextPlayerIndex;
    private Round currentRound = new Round();
    private Random random = new Random();

    public Game(int numberOfPlayers) {
        players.validate(numberOfPlayers);
        players.generate(numberOfPlayers);
    }

    public void play() {
        while(!isGameComplete())
            nextTurn(generateRoll());
    }

    public void completeGame() {
        while(!isGameComplete())
            nextTurn(10);
    }

    public void nextTurn(int roll) {
        Player player = getNextPlayer();
        takeTurn(player, roll);

        Location location = getLocation(player);
        if (player.canPurchase(location))
            player.purchase(location);

        if (players.allOtherPlayersHaveLost(player))
            return;

        nextPlayerIndex++;
        if (nextPlayerIndex >= players.getNumberOfPlayers()) {
            nextPlayerIndex = 0;
            rounds.add(currentRound);
            currentRound = new Round();
        }
    }

    private Player getNextPlayer() {
        Player player = players.getList().get(nextPlayerIndex);
        while(!player.isStillPlaying()) {
            nextPlayerIndex++;
            player = players.getList().get(nextPlayerIndex);
        }
        return player;
    }

    public int getNumberOfPlayers() {
        return players.getNumberOfPlayers();
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

    public Location getLocation(Player player) {
        return board.getLocation(player);
    }

    private int generateRoll() {
        return random.nextInt(12 - 1 + 1) + 1;
    }

    private void takeTurn(Player player, int roll) {
        board.movePlayer(roll, player);
        currentRound.takeTurn(player);
        player.addRound(currentRound);
    }

    private boolean playersRemaining() {
        return players.getNumberOfRemainingPlayers() > 1;
    }

    private boolean roundsRemaining() {
        return rounds.size() < TOTAL_ROUNDS;
    }

    private boolean isGameComplete() {
        return !playersRemaining() || !roundsRemaining();
    }
}
