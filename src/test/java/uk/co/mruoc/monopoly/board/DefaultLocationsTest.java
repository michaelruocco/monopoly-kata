package uk.co.mruoc.monopoly.board;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class DefaultLocationsTest {

    private final Location location1 = mock(Location.class);
    private final Location location2 = mock(Location.class);
    private final List<Location> values = Arrays.asList(location1, location2);

    private final Locations locations = new DefaultLocations(values);

    @Test
    void shouldBeIterable() {
        assertThat(locations).containsExactly(location1, location2);
    }

    @Test
    void shouldReturnNumberOfLocations() {
        assertThat(locations.getNumberOfLocations()).isEqualTo(values.size());
    }

    @Test
    void shouldReturnLocationAtIndex() {
        assertThat(locations.get(0)).isEqualTo(location1);
        assertThat(locations.get(1)).isEqualTo(location2);
    }

    @Test
    void shouldGetLocationIndexByName() {
        String locationName = "location-2";
        given(location2.getName()).willReturn(locationName);

        int index = locations.get(locationName);

        assertThat(index).isEqualTo(1);
    }

    @Test
    void shouldThrowExceptionIfLocationWithNameIsNotFound() {
        String locationName = "location-2";

        Throwable error = catchThrowable(() -> locations.get(locationName));

        assertThat(error)
                .isInstanceOf(LocationNotFoundException.class)
                .hasMessage(locationName);
    }

}