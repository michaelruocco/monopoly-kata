package uk.co.mruoc.monopoly.board;

import org.junit.Test;
import uk.co.mruoc.monopoly.GameException;
import uk.co.mruoc.monopoly.Player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public class BoardTest {

    private Board board = new Board();

    @Test
    public void shouldReturnBoardSize() {
        int expectedSize = 40;
        assertThat(board.size()).isEqualTo(expectedSize);
    }

    @Test
    public void shouldReturnLocationName() {
        assertThat(board.getLocationName(0)).isEqualTo("Go");
    }

    @Test
    public void shouldReturnLocationNameForPlayerPosition() {
        Player player = new Player("", board);
        player.setPosition(39);
        assertThat(board.getLocationName(player)).isEqualTo("Mayfair");
    }

    @Test
    public void shouldReturnLocationForPlayerPosition() {
        Player player = new Player("", board);
        player.setPosition(39);
        Location location = board.getLocation(player);
        assertThat(location.getName()).isEqualTo("Mayfair");
    }

    @Test
    public void shouldReturnLocationPositionForLocationName() {
        assertThat(board.getLocationPosition("Go")).isEqualTo(0);
    }

    @Test
    public void shouldThrowGameExceptionIfLocationPositionNotFound() {
        try {
            board.getLocationPosition("Invalid Location");
            fail();
        } catch (GameException e) {
            assertThat(e.getMessage()).isEqualTo("no location found with name Invalid Location");
        }
    }

    @Test
    public void shouldReturnLocationGivenName() {
        String locationName = "Just Visiting";
        Location location = board.getLocation(locationName);
        assertThat(location.getName()).isEqualTo(locationName);
    }

    @Test
    public void shouldReturnProperty() {
        String propertyName = "Pall Mall";
        Property property = board.getProperty(propertyName);
        assertThat(property.getName()).isEqualTo(propertyName);
    }

    @Test
    public void shouldThrowGameExceptionIfNameDoesNotReferToProperty() {
        try {
            board.getProperty("Go");
            fail();
        } catch (GameException e) {
            assertThat(e.getMessage()).isEqualTo("location Go is not a property");
        }
    }

}
