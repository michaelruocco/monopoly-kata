package uk.co.mruoc.monopoly.board;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {

    private final Board board = new Board();

    @Test
    void shouldReturnSizeAsFortyByDefault() {
        assertThat(board.size()).isEqualTo(40);
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
    void shouldMovePlayerByRoll() {
        String playerName = "player-1";
        int location = 5;
        int roll = 3;
        board.placePlayer(playerName, location);

        board.movePlayer(playerName, roll);

        assertThat(board.getLocation(playerName)).isEqualTo(8);
    }

    @Test
    void shouldMovePlayerPastEndOfBoard() {
        String playerName = "player-1";
        int location = 38;
        int roll = 4;
        board.placePlayer(playerName, location);

        board.movePlayer(playerName, roll);

        assertThat(board.getLocation(playerName)).isEqualTo(2);
    }
}
