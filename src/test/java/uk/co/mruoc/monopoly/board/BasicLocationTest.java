package uk.co.mruoc.monopoly.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;
import uk.co.mruoc.monopoly.Player;

public class BasicLocationTest {

    private final Location location = new BasicLocation("LOCATION");
    private final Player player = new Player("PLAYER");

    @Test
    public void shouldNotAllowOwnerToBeSet() {
        try {
            location.setOwner(player);
            fail();
        } catch (UnsupportedOperationException e) {
            assertThat(e.getMessage()).isEqualTo("basic location LOCATION cannot be purchased");
        }
    }

}
