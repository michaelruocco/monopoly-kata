package uk.co.mruoc.monopoly.board;

import org.junit.Test;
import uk.co.mruoc.monopoly.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class GoToJailTest {

    private final Board board = new Board();
    private final Location location = new GoToJail(board);
    private final Player player = new Player("NAME");

    @Test
    public void shouldReturnName() {
        assertThat(location.getName()).isEqualTo("Go To Jail");
    }

    @Test
    public void shouldMovePlayerToJail() {
        location.applyTo(player);
        assertThat(player.getPosition()).isEqualTo(board.getJailPosition());
    }

}
