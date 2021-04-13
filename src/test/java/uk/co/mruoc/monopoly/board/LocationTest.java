package uk.co.mruoc.monopoly.board;

import org.junit.jupiter.api.Test;
import uk.co.mruoc.monopoly.players.Player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;

class LocationTest {

    private static final String NAME = "location-name";

    private final Location location = new DefaultLocation(NAME);

    @Test
    void shouldReturnName() {
        assertThat(location.getName()).isEqualTo(NAME);
    }

    @Test
    void shouldDoNothingOnLand() {
        Player player = mock(Player.class);

        location.land(player);

        verifyNoInteractions(player);
    }

}