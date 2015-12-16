package uk.co.mruoc.monopoly;

import org.junit.Test;
import uk.co.mruoc.monopoly.board.Board;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    private static final String NAME = "Horse";
    private static final Board BOARD = new Board();

    private Player player = new Player(NAME, BOARD);

    @Test
    public void playerStartPositionShouldBeZero() {
        assertThat(player.getPosition()).isEqualTo(0);
    }

    @Test
    public void shouldSetPlayerPosition() {
        player.setPosition(5);

        assertThat(player.getPosition()).isEqualTo(5);
    }

    @Test
    public void shouldReturnTrueIfMatchesPlayerName() {
        assertThat(player.nameIs(NAME)).isTrue();
    }

    @Test
    public void shouldReturnFalseDoesNotMatchPlayerName() {
        assertThat(player.nameIs("NON MATCHING NAME")).isFalse();
    }

    @Test
    public void newPlayerShouldHavePlayedNoRounds() {
        assertThat(player.getNumberOfRoundsPlayed()).isEqualTo(0);
    }

    @Test
    public void numberOfRoundsPlayedShouldIncrementWithEachRoundAdded() {
        player.addRound(new Round());
        player.addRound(new Round());

        assertThat(player.getNumberOfRoundsPlayed()).isEqualTo(2);
    }

    @Test
    public void playerShouldMove() {
        player.move(8);

        assertThat(player.getPosition()).isEqualTo(8);
    }

    @Test
    public void playerLocationShouldRevertBackToZeroAfterPassingGo() {
        player.setPosition(39);

        player.move(6);

        assertThat(player.getPosition()).isEqualTo(5);
    }

}
