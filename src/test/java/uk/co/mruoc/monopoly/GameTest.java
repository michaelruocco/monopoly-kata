package uk.co.mruoc.monopoly;

import org.junit.Test;
import uk.co.mruoc.monopoly.board.Board;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    private Board board = new Board();
    private Players players = new Players(2, board);
    private Game game = new Game(players);

    @Test
    public void playerOrderShouldBeTheSameForEveryRound() {
        game.play(10);

        assertThat(playerOrderIsSameForEveryRound(game)).isTrue();
    }

    @Test
    public void newGameShouldHaveZeroRoundsPlayed() {
        assertThat(game.getNumberOfRoundsPlayed()).isEqualTo(0);
    }

    @Test
    public void gameShouldHaveTwentyRoundsPlayed() {
        game.play(10);

        assertThat(game.getNumberOfRoundsPlayed()).isEqualTo(20);
    }

    @Test
    public void shouldPlayGameWithEachRollRandomlyGenerated() {
        game.play();

        assertThat(game.isComplete()).isTrue();
    }

    @Test
    public void gameShouldReturnFalseIfGameIsNotComplete() {
        assertThat(game.isComplete()).isFalse();
    }

    @Test
    public void shouldMovePlayerAndTakeTurn() {
        Player playerOne = players.getPlayer(0);

        game.move(playerOne, 2);

        assertThat(playerOne.getNumberOfRoundsPlayed()).isEqualTo(1);
        assertThat(board.getLocationName(playerOne)).isEqualTo("Community Chest 1");
    }

    @Test
    public void shouldMoveNextPlayerAndTakeTurn() {
        Player playerOne = players.getPlayer(0);

        game.nextTurn(2);

        assertThat(playerOne.getNumberOfRoundsPlayed()).isEqualTo(1);
        assertThat(board.getLocationName(playerOne)).isEqualTo("Community Chest 1");
    }

    @Test
    public void newGameShouldHaveNoRoundsPlayed() {
        assertThat(game.getNumberOfRoundsPlayed()).isEqualTo(0);
    }

    @Test
    public void newGameShouldHaveNoRounds() {
        assertThat(game.getRounds()).isEqualTo(Collections.emptyList());
    }

    @Test
    public void shouldAddRoundWhenEachPlayerHasTakenTurn() {
        game.nextTurn(10);
        game.nextTurn(10);
        game.nextTurn(10);
        game.nextTurn(10);
        assertThat(game.getNumberOfRoundsPlayed()).isEqualTo(2);
    }

    @Test
    public void gameShouldHaveEveryRoundPlayed() {
        game.nextTurn(10);
        game.nextTurn(10);
        game.nextTurn(10);
        game.nextTurn(10);

        Round round = game.getRounds().get(1);

        assertThat(round.playersMatch(players)).isTrue();
    }

    @Test
    public void gameShouldSkipPlayerTurnIfPlayerHasLost() {
        givenPlayerOneHasLost();

        game.nextTurn(10);

        assertThat(getPlayerOne().getNumberOfRoundsPlayed()).isEqualTo(0);
        assertThat(getPlayerTwo().getNumberOfRoundsPlayed()).isEqualTo(1);
    }

    private boolean playerOrderIsSameForEveryRound(Game game) {
        for(Round round : game.getRounds())
            if (round.playersMatch(players))
                return true;
        return false;
    }

    private void givenPlayerOneHasLost() {
        Player player = getPlayerOne();
        player.setBalance(-10);
    }

    private Player getPlayerOne() {
        return players.getPlayer(0);
    }

    private Player getPlayerTwo() {
        return players.getPlayer(1);
    }

}
