package uk.co.mruoc.monopoly.chance;

import org.junit.Test;
import uk.co.mruoc.monopoly.Player;
import uk.co.mruoc.monopoly.board.Board;

import static org.assertj.core.api.Assertions.assertThat;

public class AdvanceToGoTest {

    private final Board board = new Board();
    private final ChanceCard chanceCard = new AdvanceToGo();
    private final Player player = new Player("NAME", board);

    @Test
    public void shouldMovePlayerToGoAndPaySalary() {
        player.setPosition(0);
        player.setBalance(0);

        chanceCard.applyTo(player);

        assertThat(player.getPosition()).isEqualTo(board.getLocationPosition("Go"));
        assertThat(player.getBalance()).isEqualTo(200);
    }

    @Test
    public void shouldReturnText() {
        assertThat(chanceCard.getText()).isEqualTo("Advance to GO");
    }

}
