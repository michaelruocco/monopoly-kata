package uk.co.mruoc.monopoly;

import org.junit.Test;
import uk.co.mruoc.monopoly.board.Board;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    private Board board = new Board();
    private Players players = new Players(2, board);

    @Test
    public void playerOrderShouldBeTheSameForEveryRound() {
        Game game = new Game(players);

        game.play();

        assertThat(game.playerOrderIsSameForEveryRound()).isTrue();
    }

}
