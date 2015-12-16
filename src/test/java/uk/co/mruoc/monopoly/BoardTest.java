package uk.co.mruoc.monopoly;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    private uk.co.mruoc.monopoly.board.Board board = new uk.co.mruoc.monopoly.board.Board();

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
        uk.co.mruoc.monopoly.board.Location location = board.getLocation(player);
        assertThat(location.getName()).isEqualTo("Mayfair");
    }

    @Test
    public void shouldReturnLocationPositionForLocationName() {
        assertThat(board.getLocationPosition("Go")).isEqualTo(0);
    }

    @Test
    public void shouldReturnLocationGivenName() {
        String locationName = "Just Visiting / Jail";
        uk.co.mruoc.monopoly.board.Location location = board.getLocation(locationName);
        assertThat(location.getName()).isEqualTo(locationName);
    }

    @Test
    public void shouldReturnJailPosition() {
        int expectedJailPosition = 10;
        assertThat(board.getJailPosition()).isEqualTo(expectedJailPosition);
    }

}
