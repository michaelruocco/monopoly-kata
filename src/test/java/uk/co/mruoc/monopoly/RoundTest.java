package uk.co.mruoc.monopoly;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundTest {

    private static final Player HORSE = new Player("Horse");
    private static final Player CAT = new Player("Cat");
    private static final List<Player> ROUND_PLAYERS = Arrays.asList(HORSE, CAT);

    private final Round round = new Round();

    @Test
    public void roundShouldHaveNoPlayersIfNoTurnsHaveBeenTaken() {
        boolean playersMatch = round.playersMatch(new ArrayList<>());
        assertThat(playersMatch).isTrue();
    }

    @Test
    public void shouldAddPlayerToRound() {
        round.takeTurn(HORSE);

        boolean playersMatch = round.playersMatch(Arrays.asList(HORSE));

        assertThat(playersMatch).isTrue();
    }

    @Test
    public void shouldAddMultiplePlayersToRound() {
        round.takeTurn(HORSE);
        round.takeTurn(CAT);

        boolean playersMatch = round.playersMatch(Arrays.asList(HORSE, CAT));

        assertThat(playersMatch).isTrue();
    }

    @Test
    public void playersShouldNotMatchIfNumberOfPlayersIsDifferent() {
        round.takeTurn(CAT);

        boolean playersMatch = round.playersMatch(Arrays.asList(HORSE, CAT));

        assertThat(playersMatch).isFalse();
    }

    @Test
    public void shouldPlayersShouldNotMatchIfPlayersAreInDifferentOrder() {
        round.takeTurn(CAT);
        round.takeTurn(HORSE);

        boolean playersMatch = round.playersMatch(Arrays.asList(HORSE, CAT));

        assertThat(playersMatch).isFalse();
    }

}
