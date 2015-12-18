package uk.co.mruoc.monopoly.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import uk.co.mruoc.monopoly.Player;

public class BasicLocationTest {

    private static final String LOCATION_NAME = "LOCATION";

    private final Location location = new BasicLocation(LOCATION_NAME);
    private final Player player = new Player("PLAYER");

    @Test
    public void shouldReturnName() {
        assertThat(location.getName()).isEqualTo(LOCATION_NAME);
    }

    @Test
    public void shouldReturnTrueIfEqualsName() {
        assertThat(location.nameEquals(LOCATION_NAME)).isTrue();
    }

    @Test
    public void shouldReturnFalseIfDoesNotEqualName() {
        assertThat(location.nameEquals("NOT_EQUAL")).isFalse();
    }

}
