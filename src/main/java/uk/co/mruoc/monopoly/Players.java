package uk.co.mruoc.monopoly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Players {

    private static final String[] NAMES = { "Horse" , "Car", "Boat", "Dog", "Thimble", "Boot", "Hat", "Wheelbarrow" };
    private static final int MAX_PLAYERS = NAMES.length;

    private final PlayersValidator validator = new PlayersValidator(Players.MAX_PLAYERS);
    private final List<Player> players = new ArrayList();

    public void validate(int numberOfPlayers) {
        validator.validate(numberOfPlayers);
    }

    public void generate(int numberOfPlayers) {
        for(int p = 0; p < numberOfPlayers; p++)
            players.add(new Player(NAMES[p]));
        Collections.shuffle(players);
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public int count() {
        return players.size();
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

    public boolean allOtherPlayersHaveLost(Player player) {
        List<Player> otherPlayers = new ArrayList<>(players);
        Collections.copy(otherPlayers, players);
        otherPlayers.remove(player);
        return allHaveLost(otherPlayers);
    }

    public Player getWinner() {
        List<Player> remainingPlayers = getRemainingPlayers();
        return getPlayerWithHighestBalance(remainingPlayers);
    }

    private boolean allHaveLost(List<Player> otherPlayers) {
        for (Player player : otherPlayers)
            if (!player.hasLost())
                return false;
        return true;
    }

    private List<Player> getRemainingPlayers() {
        List<Player> remainingPlayers = new ArrayList<>();
        for (Player player : players)
            if (!player.hasLost())
                remainingPlayers.add(player);
        return remainingPlayers;
    }

    private Player getPlayerWithHighestBalance(List<Player> remainingPlayers) {
        Player playerWithHighestBalance = remainingPlayers.get(0);
        for (Player remainingPlayer : remainingPlayers)
            if (remainingPlayer.getBalance() > playerWithHighestBalance.getBalance())
                playerWithHighestBalance = remainingPlayer;
        return playerWithHighestBalance;
    }

}
