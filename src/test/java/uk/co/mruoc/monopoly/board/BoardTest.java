package uk.co.mruoc.monopoly.board;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class BoardTest {

    private static final int NUMBER_OF_LOCATIONS = 40;

    private final Locations locations = mock(Locations.class);

    private final Board board = new Board(locations);

    @Test
    void shouldReturnSizeAsFortyByDefault() {
        givenNumberOfLocations();

        int size = board.size();

        assertThat(size).isEqualTo(NUMBER_OF_LOCATIONS);
    }

    @Test
    void shouldAddPlayerAtZeroLocation() {
        String playerName = "player-1";

        board.addPlayer(playerName);

        assertThat(board.getLocation(playerName)).isZero();
    }

    @Test
    void shouldPlaceGivenPlayerAtLocation() {
        String playerName = "player-1";
        int location = 5;

        board.placePlayer(playerName, location);

        assertThat(board.getLocation(playerName)).isEqualTo(location);
    }

    @Test
    void shouldPlaceGivenPlayerAtLocationByName() {
        String playerName = "player-1";
        String locationName = "location-name";
        int locationIndex = 5;
        given(locations.get(locationName)).willReturn(locationIndex);
        Location location = givenLocationWithName(locationName);
        given(locations.get(locationIndex)).willReturn(location);

        board.placePlayer(playerName, locationName);

        assertThat(board.getLocationName(playerName)).isEqualTo(locationName);
    }

    @Test
    void shouldMovePlayerByRoll() {
        givenNumberOfLocations();
        String playerName = "player-1";
        int location = 5;
        int roll = 3;
        board.placePlayer(playerName, location);

        board.movePlayer(playerName, roll);

        assertThat(board.getLocation(playerName)).isEqualTo(8);
    }

    @Test
    void shouldMovePlayerPastEndOfBoard() {
        givenNumberOfLocations();
        String playerName = "player-1";
        int location = 38;
        int roll = 4;
        board.placePlayer(playerName, location);

        board.movePlayer(playerName, roll);

        assertThat(board.getLocation(playerName)).isEqualTo(2);
    }

    private void givenNumberOfLocations() {
        given(locations.getNumberOfLocations()).willReturn(NUMBER_OF_LOCATIONS);
    }

    private Location givenLocationWithName(String name) {
        Location location = mock(Location.class);
        given(location.getName()).willReturn(name);
        return location;
    }

}
