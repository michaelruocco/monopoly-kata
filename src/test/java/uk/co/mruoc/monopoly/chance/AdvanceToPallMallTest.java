package uk.co.mruoc.monopoly.chance;

import org.junit.Test;
import uk.co.mruoc.monopoly.Player;
import uk.co.mruoc.monopoly.board.Board;
import uk.co.mruoc.monopoly.board.Property;

import static org.assertj.core.api.Assertions.assertThat;

public class AdvanceToPallMallTest {

    private static final String LOCATION_NAME = "Pall Mall";

    private final Board board = new Board();
    private final ChanceCard chanceCard = new AdvanceToPallMall();
    private final Player player = new Player("NAME", board);

    @Test
    public void shouldMovePlayerToPallMallWithNoSalaryIfDoesntPassGo() {
        player.setPosition(0);
        player.setBalance(0);

        chanceCard.applyTo(player);

        assertThat(player.getPosition()).isEqualTo(board.getLocationPosition(LOCATION_NAME));
        assertThat(player.getBalance()).isEqualTo(0);
    }


    @Test
    public void shouldMovePlayerToPallMallWithSalaryIfPassesGo() {
        int position = board.getLocationPosition(LOCATION_NAME);
        Property property = board.getProperty(LOCATION_NAME);
        property.setOwner(player);
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
