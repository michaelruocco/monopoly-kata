package uk.co.mruoc.monopoly;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    private Board board = new Board();
    private Player player = new Player("NAME");

    @Test
    public void shouldMovePlayerPosition() {
        board.movePlayer(8, player);

        assertThat(player.getPosition()).isEqualTo(8);
    }

    @Test
    public void playerLocationShouldRevertBackToZeroAfterLocationForty() {
        player.setPosition(39);

        board.movePlayer(6, player);

        assertThat(player.getPosition()).isEqualTo(5);
    }

}
