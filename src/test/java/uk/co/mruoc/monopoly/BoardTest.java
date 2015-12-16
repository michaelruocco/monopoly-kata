package uk.co.mruoc.monopoly;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    private Board board = new Board();
    private Player player = new Player("NAME", board);

    @Test
    public void shouldMovePlayerPosition() {
        player.move(8);

        assertThat(player.getPosition()).isEqualTo(8);
    }

    @Test
    public void playerLocationShouldRevertBackToZeroAfterLocationForty() {
        player.setPosition(39);

        player.move(6);

        assertThat(player.getPosition()).isEqualTo(5);
    }

}
