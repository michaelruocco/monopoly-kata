package uk.co.mruoc.monopoly;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    private static final String NAME = "NAME";

    private Player player = new Player(NAME);

    @Test
    public void shouldDefaultPlayerPositionToZero() {
        assertThat(player.getPosition()).isEqualTo(0);
    }

    @Test
    public void shouldSetPlayerPosition() {
        player.setPosition(5);

        assertThat(player.getPosition()).isEqualTo(5);
    }

    @Test
    public void nameIsShouldReturnTrueIfMatchesPlayerName() {
        assertThat(player.nameIs(NAME)).isTrue();
    }

    @Test
    public void nameIsShouldReturnFalseDoesNotMatchPlayerName() {
        assertThat(player.nameIs("NON MATCHING NAME")).isFalse();
    }

    @Test
    public void newPlayerShouldHavePlayedNoRounds() {
        assertThat(player.getNumberOfRoundsPlayed()).isEqualTo(0);
    }

    @Test
    public void shouldAddRoundToPlayer() {
        player.addRound(new Round());
        player.addRound(new Round());

        assertThat(player.getNumberOfRoundsPlayed()).isEqualTo(2);
    }

}
