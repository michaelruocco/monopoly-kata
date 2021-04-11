package uk.co.mruoc.monopoly;

import org.junit.jupiter.api.Test;
import uk.co.mruoc.monopoly.players.GreaterThanMaxPlayersException;
import uk.co.mruoc.monopoly.players.LessThanMinPlayersException;
import uk.co.mruoc.monopoly.players.Players;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.catchThrowable;

class PlayersTest {

    @Test
    void shouldThrowExceptionIfLessThanMinPlayersPassed() {
        String[] names = generatePlayerNames(1);

        Throwable error = catchThrowable(() -> new Players(names));

        assertThat(error)
                .isInstanceOf(LessThanMinPlayersException.class)
                .hasMessage("game has 1 players, cannot create a game with less than 2 players");
    }

    @Test
    void shouldAllowMinOrMorePlayers() {
        String[] names = generatePlayerNames(2);

        assertThatCode(() -> new Players(names)).doesNotThrowAnyException();
    }

    @Test
    void shouldAllowMaxOrLessPlayers() {
        String[] names = generatePlayerNames(8);

        assertThatCode(() -> new Players(names)).doesNotThrowAnyException();
    }

    @Test
    void shouldThrowExceptionIfMoreThanMaxPlayersPassed() {
        String[] names = generatePlayerNames(9);

        Throwable error = catchThrowable(() -> new Players(names));

        assertThat(error)
                .isInstanceOf(GreaterThanMaxPlayersException.class)
                .hasMessage("game has 9 players, cannot create a game with more than 8 players");
    }

    private static String[] generatePlayerNames(int numberOfNames) {
        return IntStream.rangeClosed(1, numberOfNames)
                .mapToObj(i -> String.format("name-%d", i))
                .toArray(String[]::new);
    }
}
