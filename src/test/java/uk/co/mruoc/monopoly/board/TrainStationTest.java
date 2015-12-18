package uk.co.mruoc.monopoly.board;

import org.junit.Test;
import uk.co.mruoc.monopoly.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class TrainStationTest {

    private final Location station1 = new TrainStation("Station1");
    private final Location station2 = new TrainStation("Station2");
    private final Player player = new Player("PLAYER");

    @Test
    public void playerShouldPayOwnerTwentyFiveRentIfOwnerOwnsOneStation() {
        Player owner = new Player("OWNER");
        station1.setOwner(owner);

        owner.setBalance(0);
        player.setBalance(200);

        station1.applyTo(player);

        assertThat(owner.getBalance()).isEqualTo(25);
        assertThat(player.getBalance()).isEqualTo(175);
    }

    @Test
    public void playerShouldPayOwnerFiftyRentIfOwnerOwnsTwoStations() {
        Player owner = new Player("OWNER");
        station1.setOwner(owner);
        station2.setOwner(owner);

        owner.setBalance(0);
        player.setBalance(200);

        station1.applyTo(player);

        assertThat(owner.getBalance()).isEqualTo(50);
        assertThat(player.getBalance()).isEqualTo(150);
    }

}
