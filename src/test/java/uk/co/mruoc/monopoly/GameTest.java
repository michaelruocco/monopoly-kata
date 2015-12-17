package uk.co.mruoc.monopoly;

import org.junit.Test;
import uk.co.mruoc.monopoly.board.Board;

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

    public boolean playerOrderIsSameForEveryRound(Game game) {
        for(Round round : game.getRounds())
            if (round.playersMatch(players))
                return true;
        return false;
    }

}
