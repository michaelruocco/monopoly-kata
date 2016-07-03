package uk.co.mruoc.monopoly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private static final int TOTAL_ROUNDS = 20;

    private final List<Round> rounds = new ArrayList<>(TOTAL_ROUNDS);
    private final Random random = new Random();

    private final Players players;

    private Round currentRound = new Round();
    private int nextPlayerIndex;
    private int doubleCount;

    public Game(Players players) {
        this.players = players;
    }

    public void play() {
        while(!isComplete())
            nextTurn(generateRoll());
    }

    public void play(int fixedRollValue) {
        play(new Roll(fixedRollValue, 0));
    }

    public void play(Roll fixedRoll) {
        while(!isComplete())
            nextTurn(fixedRoll);
    }

    public boolean isComplete() {
        return !playersRemaining() || !roundsRemaining();
    }

    public void nextTurn(int rollValue) {
        Player player = getNextPlayer();
        move(player, new Roll(rollValue, 0));
    }

    public void nextTurn(Roll roll) {
        Player player = getNextPlayer();
        move(player, roll);
    }

    public void move(Player player, int rollValue) {
        move(player, new Roll(rollValue, 0));
    }

    public void move(Player player, Roll roll) {
        if (player.isInJail() && player.canAffordBail())
                player.payBail();
        movePlayer(player, roll);
        currentRound.takeTurn(player);
        player.endTurn(roll);
        setNextPlayer(roll);
    }

    private void movePlayer(Player player, Roll roll) {
        if (threeConsecutiveDoubles(roll)) {
            player.goToJail();
            return;
        }
        player.move(roll);
    }

    private boolean threeConsecutiveDoubles(Roll roll) {
        if (doubleCount == 2)
            return roll.isDouble();
        return false;
    }

    public int getNumberOfRoundsPlayed() {
        return rounds.size();
    }

    public List<Round> getRounds() {
        return rounds;
    }

    private Roll generateRoll() {
        int dice1 = generateDiceValue();
        int dice2 = generateDiceValue();
        return new Roll(dice1, dice2);
    }

    private int generateDiceValue() {
        return random.nextInt(6) + 1;
    }

    private Player getNextPlayer() {
        Player player = players.getPlayer(nextPlayerIndex);
        while(player.hasLost())
            player = skipPlayer();
        return player;
    }

    private Player skipPlayer() {
        setNextPlayer();
        return players.getPlayer(nextPlayerIndex);
    }

    private void setNextPlayer(Roll roll) {
        if (roll.isDouble()) {
            doubleCount++;
            return;
        }
        setNextPlayer();
        if (nextPlayerIndex >= players.getNumberOfPlayers())
            setNextRound();
    }

    private void setNextPlayer() {
        nextPlayerIndex++;
        doubleCount = 0;
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

}
