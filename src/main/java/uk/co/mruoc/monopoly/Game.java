package uk.co.mruoc.monopoly;

import uk.co.mruoc.monopoly.board.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private static final int TOTAL_ROUNDS = 20;

    private final List<Round> rounds = new ArrayList<>(TOTAL_ROUNDS);

    private final Players players;

    private int nextPlayerIndex;
    private Round currentRound = new Round();
    private Random random = new Random();

    public Game(int numberOfPlayers, Board board) {
        this(new Players(numberOfPlayers, board));
    }

    public Game(Players players) {
        this.players = players;
    }

    public void play() {
        while(!isComplete())
            nextTurn(generateRoll());
    }

    public void complete() {
        while(!isComplete())
            nextTurn(10);
    }

    public void nextTurn(int roll) {
        Player player = getNextPlayer();
        move(player, roll);
    }

    public void move(Player player, int roll) {
        player.move(roll);
        currentRound.takeTurn(player);
        player.addRound(currentRound);
        player.endTurn();
        setNextPlayer();
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

    private int generateRoll() {
        return random.nextInt(12) + 1;
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

    private boolean isComplete() {
        return !playersRemaining() || !roundsRemaining();
    }

}
