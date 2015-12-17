package uk.co.mruoc.monopoly;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundTest {

    private final Player horse = new Player("Horse");
    private final Player cat = new Player("Cat");

    private final Round round = new Round();

    @Test
    public void roundShouldHaveNoPlayersIfNoTurnsHaveBeenTaken() {
        boolean playersMatch = round.playersMatch(new ArrayList<Player>());
        assertThat(playersMatch).isTrue();
    }

    @Test
    public void shouldAddPlayerToRound() {
        round.takeTurn(horse);

        boolean playersMatch = round.playersMatch(Arrays.asList(horse));

        assertThat(playersMatch).isTrue();
    }

    @Test
    public void shouldAddMultiplePlayersToRound() {
        round.takeTurn(horse);
        round.takeTurn(cat);

        boolean playersMatch = round.playersMatch(Arrays.asList(horse, cat));

        assertThat(playersMatch).isTrue();
    }

    @Test
    public void playersShouldNotMatchIfNumberOfPlayersIsDifferent() {
        round.takeTurn(cat);

        boolean playersMatch = round.playersMatch(Arrays.asList(horse, cat));

        assertThat(playersMatch).isFalse();
    }

    @Test
    public void shouldPlayersShouldNotMatchIfPlayersAreInDifferentOrder() {
        round.takeTurn(cat);
        round.takeTurn(horse);

        boolean playersMatch = round.playersMatch(Arrays.asList(horse, cat));

        assertThat(playersMatch).isFalse();
    }

}
