package uk.co.mruoc.monopoly;

import org.apache.log4j.Logger;
import uk.co.mruoc.monopoly.board.Board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Players {

    private static Logger LOG = Logger.getLogger(Players.class);

    private static final String[] NAMES = { "Horse" , "Car", "Boat", "Dog", "Thimble", "Boot", "Hat", "Wheelbarrow" };
    private static final int MAX_PLAYERS = NAMES.length;

    private final PlayersValidator validator = new PlayersValidator(Players.MAX_PLAYERS);
    private final List<Player> players = new ArrayList<>();
    private final Board board;

    public Players(int numberOfPlayers, Board board) {
        this.board = board;
        validate(numberOfPlayers);
        generate(numberOfPlayers);
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public int getNumberOfPlayers() {
        return players.size();
    }

    public int getNumberOfRemainingPlayers() {
        return getRemainingPlayers().size();
    }

    public boolean exists(String name) {
        for(Player player : players)
            if (player.nameIs(name))
                return true;
        return false;
    }

    public List<Player> getList() {
        return players;
    }

    public boolean onlyRemainingPlayer(Player player) {
        List<Player> otherPlayers = new ArrayList<>(players);
        Collections.copy(otherPlayers, players);
        otherPlayers.remove(player);
        return allHaveLost(otherPlayers);
    }

    public Player getWinner() {
        List<Player> remainingPlayers = getRemainingPlayers();
        return getPlayerWithHighestBalance(remainingPlayers);
    }

    public List<Player> getRemainingPlayers() {
        List<Player> remainingPlayers = new ArrayList<>();
        for (Player player : players)
            if (!player.hasLost())
                remainingPlayers.add(player);
        return remainingPlayers;
    }

    private void validate(int numberOfPlayers) {
        validator.validate(numberOfPlayers);
    }

    private void generate(int numberOfPlayers) {
        for(int p = 0; p < numberOfPlayers; p++)
            players.add(new Player(NAMES[p], board));
        Collections.shuffle(players);
        for (Player player : players)
            logInfo("generated player " + player.getName());
    }

    private boolean allHaveLost(List<Player> otherPlayers) {
        for (Player player : otherPlayers)
            if (!player.hasLost())
                return false;
        return true;
    }

    private Player getPlayerWithHighestBalance(List<Player> remainingPlayers) {
        Player playerWithHighestBalance = null;
        for (Player remainingPlayer : remainingPlayers) {
            if (playerWithHighestBalance == null || (remainingPlayer.getBalance() > playerWithHighestBalance.getBalance()))
                playerWithHighestBalance = remainingPlayer;
        }
        return playerWithHighestBalance;
    }

    private void logInfo(String message) {
        LOG.info(message);
    }

}
