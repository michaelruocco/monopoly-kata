package uk.co.mruoc.monopoly.board;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LocationTest {

    private static final String NAME = "location-name";

    private final Location location = new Location(NAME);

    @Test
    void shouldReturnName() {
        assertThat(location.getName()).isEqualTo(NAME);
    }

}