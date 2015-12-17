package uk.co.mruoc.monopoly;

import org.junit.Test;
import uk.co.mruoc.monopoly.board.Board;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    private static final int NUMBER_OF_PLAYERS = 2;

    private final Board board = new Board();
    private final Players players = new Players(NUMBER_OF_PLAYERS, board);

    @Test
    public void shouldReturnPlayers() {
        assertThat(players.getNumberOfPlayers()).isEqualTo(NUMBER_OF_PLAYERS);
        assertThat(players.getPlayer(0)).isNotNull();
        assertThat(players.getPlayer(1)).isNotNull();

    }

    @Test
    public void shouldReturnPlayersThatExist() {
        assertThat(players.exists("Horse")).isTrue();
        assertThat(players.exists("Car")).isTrue();
        assertThat(players.exists("DOESNT_EXIST")).isFalse();
    }

    @Test
    public void shouldReturnRemainingPlayers() {
        assertThat(players.getRemainingPlayers()).isEqualTo(players.getList());
        assertThat(players.getNumberOfRemainingPlayers()).isEqualTo(players.getNumberOfPlayers());
        assertThat(players.onlyRemainingPlayer(getPlayerOne())).isFalse();
        assertThat(players.onlyRemainingPlayer(getPlayerTwo())).isFalse();
    }

    @Test
    public void shouldReturnRemainingPlayersIfOneHasLost() {
        givenPlayerOneHasLost();

        List<Player> remainingPlayers = players.getRemainingPlayers();

        assertThat(remainingPlayers.size()).isEqualTo(1);
        assertThat(remainingPlayers.contains(getPlayerTwo())).isTrue();
        assertThat(players.onlyRemainingPlayer(getPlayerTwo())).isTrue();
    }

    @Test
    public void shouldReturnWinner() {
        givenPlayerOneHasLost();

        assertThat(players.getWinner()).isEqualTo(getPlayerTwo());
    }

    @Test
    public void shouldReturnPlayerWithHighestBalanceAsWinnerIfMultiplePlayersRemaining() {
        Player playerOne = getPlayerOne();
        playerOne.setBalance(100);

        assertThat(players.getWinner()).isEqualTo(playerOne);
    }

    @Test
    public void shouldReturnNotReturnWinnerIfAllPlayersHaveLost() {
        givenPlayerOneHasLost();
        givenPlayerTwoHasLost();

        assertThat(players.getWinner()).isNull();
    }

    private void givenPlayerOneHasLost() {
        Player player = getPlayerOne();
        player.setBalance(-10);
    }

    private void givenPlayerTwoHasLost() {
        Player player = getPlayerTwo();
        player.setBalance(-10);
    }

    private Player getPlayerOne() {
        return players.getPlayer(0);
    }

    private Player getPlayerTwo() {
        return players.getPlayer(1);
    }

}
