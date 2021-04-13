package uk.co.mruoc.monopoly;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import uk.co.mruoc.monopoly.board.Board;
import uk.co.mruoc.monopoly.board.Location;
import uk.co.mruoc.monopoly.players.Player;
import uk.co.mruoc.monopoly.players.Players;
import uk.co.mruoc.monopoly.players.RandomOrderPlayers;
import uk.co.mruoc.monopoly.round.Round;
import uk.co.mruoc.monopoly.round.Rounds;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;

import static uk.co.mruoc.monopoly.players.Players.toPlayers;

@RequiredArgsConstructor
@Slf4j
public class Game {

    private final Players players;
    private final Board board;
    private final Rounds rounds;

    public Game(String... playerNames) {
        this(Arrays.asList(playerNames));
    }

    public Game(Collection<String> playerNames) {
        this(new RandomOrderPlayers(toPlayers(playerNames)));
    }

    public Game(Players players) {
        this(players, new Board(), new Rounds());
    }

    public void play() {
        start();
        IntStream.range(0, rounds.getNumberOfRounds()).forEach(i -> playRound());
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

    public void setPlayerLocation(String playerName, String locationName) {
        board.placePlayer(playerName, locationName);
    }

    public void setPlayerLocation(String playerName, int location) {
        board.placePlayer(playerName, location);
    }

    public void playTurn(String name, int rolled) {
        Location location = board.movePlayer(name, rolled);
        Player player = players.forceFind(name);
        location.land(player);
    }

    public String getPlayerLocationName(String playerName) {
        return board.getLocationName(playerName);
    }

    public int getPlayerLocation(String playerName) {
        return board.getLocation(playerName);
    }

    public long getNumberOfRoundsPlayed() {
        return rounds.getNumberOfRoundsPlayed();
    }

    public long getNumberOfRoundsPlayedBy(String name) {
        return rounds.getNumberOfRoundsPlayedBy(name);
    }

    public boolean playerOrderIsTheSameForEveryRound() {
        return rounds.allHavePlayersInSameOrder();
    }

    private void start() {
        players.streamNames().forEach(board::addPlayer);
    }

    private void playRound() {
        Round round = rounds.startNextRound();
        do {
            String player = players.getNextPlayerName();
            round.addPlayer(player);
            log.info("rolling for player {} on round {}", player, round.getNumber());
            players.updateNextPlayer();
        } while (!players.isFirstPlayerNext());
        log.info("round {} complete", round.getNumber());
    }

    public BigDecimal getPlayerBalance(String name) {
        return players.getBalance(name);
    }
}
