package uk.co.mruoc.monopoly;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationTest {

    private static final String GO = "GO";

    private Location location = new Location(GO);

    @Test
    public void shouldReturnName() {
        assertThat(location.getName()).isEqualTo(GO);
    }

}
