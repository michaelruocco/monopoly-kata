package uk.co.mruoc.monopoly.players;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    @Test
    void shouldHaveAllPlayerNames() {
        String[] names = generatePlayerNames(2);

        Players players = new Players(names);

        assertThat(players).containsExactly(names);
    }

    @Test
    void containsShouldReturnTrueIfNameIsPresent() {
        String[] names = generatePlayerNames(2);

        Players players = new Players(names);

        assertThat(players.contains("name-1")).isTrue();
    }

    @Test
    void containsShouldReturnFalseIfNameIsNotPresent() {
        String[] names = generatePlayerNames(2);

        Players players = new Players(names);

        assertThat(players.contains("other-name")).isFalse();
    }

    @Test
    void shouldReturnIsNextPlayer() {
        String[] names = generatePlayerNames(2);
        Players players = new Players(names);

        boolean isNext = players.isNext(names[0]);

        assertThat(isNext).isTrue();
    }

    @Test
    void shouldReturnNextPlayer() {
        String[] names = generatePlayerNames(2);
        Players players = new Players(names);

        String nextPlayer = players.getNextPlayerName();

        assertThat(nextPlayer).isEqualTo(names[0]);
    }

    @Test
    void shouldReturnStreamOfPlayerNames() {
        String[] names = generatePlayerNames(2);
        Players players = new Players(names);

        Stream<String> stream = players.streamNames();

        assertThat(stream).containsExactlyInAnyOrder(names);
    }

    @Test
    void shouldReturnSize() {
        int numberOfPlayers = 2;
        Players players = new Players(generatePlayerNames(numberOfPlayers));

        int size = players.size();

        assertThat(size).isEqualTo(numberOfPlayers);
    }

    @Test
    void shouldReturnTrueIfNextPlayerIsFirstPlayer() {
        Players players = new Players(generatePlayerNames(2));

        boolean isFirst = players.isFirstPlayerNext();

        assertThat(isFirst).isTrue();
    }

    @Test
    void shouldReturnFalseIfNextPlayerIsNotFirstPlayer() {
        Players players = new Players(generatePlayerNames(2));
        players.updateNextPlayer();

        boolean isFirst = players.isFirstPlayerNext();

        assertThat(isFirst).isFalse();
    }

    @Test
    void shouldSetNextPlayerBackToZeroOnLastPlayer() {
        Players players = new Players(generatePlayerNames(2));
        players.updateNextPlayer();
        players.updateNextPlayer();

        boolean isFirst = players.isFirstPlayerNext();

        assertThat(isFirst).isTrue();
    }

    private static String[] generatePlayerNames(int numberOfPlayers) {
        return IntStream.rangeClosed(1, numberOfPlayers)
                .mapToObj(i -> String.format("name-%d", i))
                .toArray(String[]::new);
    }
}
