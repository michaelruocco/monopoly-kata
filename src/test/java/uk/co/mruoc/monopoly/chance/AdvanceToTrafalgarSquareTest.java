package uk.co.mruoc.monopoly.chance;

import org.junit.Test;
import uk.co.mruoc.monopoly.Player;
import uk.co.mruoc.monopoly.board.Board;

import static org.assertj.core.api.Assertions.assertThat;

public class AdvanceToTrafalgarSquareTest {

    private final Board board = new Board();
    private final ChanceCard chanceCard = new AdvanceToTrafalgarSquare();
    private final Player player = new Player("NAME");

    @Test
    public void shouldMovePlayerToTrafalgarSquareWithNoSalaryIfDoesntPassGo() {
        player.setPosition(0);
        player.setBalance(0);

        chanceCard.applyTo(player);

        assertThat(player.getPosition()).isEqualTo(board.getLocationPosition("Trafalgar Square"));
        assertThat(player.getBalance()).isEqualTo(0);
    }


    @Test
    public void shouldPayPlayerSalaryIfPassesGo() {
        int trafalgarPosition = board.getLocationPosition("Trafalgar Square");
        player.setPosition(trafalgarPosition + 1);
        player.setBalance(0);

        chanceCard.applyTo(player);

        assertThat(player.getPosition()).isEqualTo(trafalgarPosition);
        assertThat(player.getBalance()).isEqualTo(200);
    }

    @Test
    public void shouldReturnText() {
        assertThat(chanceCard.getText()).isEqualTo("Advance to Trafalgar Square. If you pass GO, collect £200");
    }

}
