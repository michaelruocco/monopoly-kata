package uk.co.mruoc.monopoly;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public class PlayersValidatorTest {

    private final PlayersValidator validator = new PlayersValidator();

    @Test
    public void shouldThrowExceptionIfLessThanTwoPlayers() {
        try {
            validator.validate(1);
            fail();
        } catch (GameException e) {
            assertThat(e.getMessage()).isEqualTo("cannot create a game with less than 2 players");
        }
    }

    @Test
    public void shouldReturnTrueForTwoOrMorePlayers() {
        assertThat(validator.validate(2)).isTrue();
    }

    @Test
    public void shouldReturnTrueForEightOrLessPlayers() {
        assertThat(validator.validate(8)).isTrue();
    }

    @Test
    public void shouldThrowExceptionIfMoreThanEightPlayers() {
        try {
            validator.validate(9);
            fail();
        } catch (GameException e) {
            assertThat(e.getMessage()).isEqualTo("cannot create a game with more than 8 players");
        }
    }

}
