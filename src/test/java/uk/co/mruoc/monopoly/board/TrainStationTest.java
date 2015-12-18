package uk.co.mruoc.monopoly.board;

import org.junit.Test;
import uk.co.mruoc.monopoly.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class TrainStationTest {

    private static final String NAME = "NAME";

    private final Location location = new TrainStation(NAME);
    private final Player player = new Player("PLAYER");

    @Test
    public void playerShouldPayOwnerRent() {
        Player owner = new Player("OWNER");
        location.setOwner(owner);

        owner.setBalance(0);
        player.setBalance(200);

        location.applyTo(player);

        assertThat(owner.getBalance()).isEqualTo(25);
        assertThat(player.getBalance()).isEqualTo(175);
    }

}
