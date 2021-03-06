package uk.co.mruoc.monopoly.chance;

import org.junit.Test;
import uk.co.mruoc.monopoly.Player;
import uk.co.mruoc.monopoly.board.Board;

import static org.assertj.core.api.Assertions.assertThat;

public class AdvanceToTrafalgarSquareTest {

    private static final String LOCATION_NAME = "Trafalgar Square";

    private final Board board = new Board();
    private final ChanceCard chanceCard = new AdvanceToTrafalgarSquare();
    private final Player player = new Player("NAME");

    @Test
    public void shouldMovePlayerToTrafalgarSquareWithNoSalaryIfDoesntPassGo() {
        player.setPosition(0);
        player.setBalance(0);

        chanceCard.applyTo(player);

        assertThat(player.getPosition()).isEqualTo(board.getLocationPosition(LOCATION_NAME));
        assertThat(player.getBalance()).isEqualTo(0);
    }


    @Test
    public void shouldMovePlayerToTrafalgarSquareWithSalaryIfPassesGo() {
        int position = board.getLocationPosition(LOCATION_NAME);
        player.setPosition(position + 1);
        player.setBalance(0);

        chanceCard.applyTo(player);

        assertThat(player.getPosition()).isEqualTo(position);
        assertThat(player.getBalance()).isEqualTo(200);
    }

    @Test
    public void shouldReturnText() {
        assertThat(chanceCard.getText()).isEqualTo("Advance to " + LOCATION_NAME + ". If you pass GO, collect £200");
    }

}
