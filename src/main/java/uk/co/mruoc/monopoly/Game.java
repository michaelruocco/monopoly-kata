package uk.co.mruoc.monopoly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private static final int TOTAL_ROUNDS = 20;

    private final List<Round> rounds = new ArrayList(TOTAL_ROUNDS);

    private final Board board;
    private final Players players;

    private int nextPlayerIndex;
    private Round currentRound = new Round();
    private Random random = new Random();

    public Game(int numberOfPlayers) {
        this(new Board(), new Players(numberOfPlayers));
    }

    public Game(Board board, Players players) {
        this.board = board;
        this.players = players;
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
        move(player, roll);
    }

    public void move(Player player, int roll) {
        board.movePlayer(roll, player);
        currentRound.takeTurn(player);
        player.addRound(currentRound);
        board.applyRules(player);
        if (players.onlyRemainingPlayer(player))
            return;
        setNextPlayer();
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

    private int generateRoll() {
        return random.nextInt(12 - 1 + 1) + 1;
    }

    private Player getNextPlayer() {
        Player player = players.getList().get(nextPlayerIndex);
        while(!player.isStillPlaying()) {
            nextPlayerIndex++;
            player = players.getList().get(nextPlayerIndex);
        }
        return player;
    }

    private void setNextPlayer() {
        nextPlayerIndex++;
        if (nextPlayerIndex >= players.getNumberOfPlayers())
            setNextRound();
    }

    private void setNextRound() {
        nextPlayerIndex = 0;
        rounds.add(currentRound);
        currentRound = new Round();
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
