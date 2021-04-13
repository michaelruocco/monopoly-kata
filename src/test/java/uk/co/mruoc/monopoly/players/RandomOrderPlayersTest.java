package uk.co.mruoc.monopoly.players;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomOrderPlayersTest {

    private static final int NUMBER_OF_PLAYERS = 2;

    @Test
    void shouldHaveAllPlayerNamesAndRandomizedOrder() {
        String[] names = PlayerNames.generate(NUMBER_OF_PLAYERS);

        Players players = new RandomOrderPlayers(names);

        assertThat(players).containsExactlyInAnyOrder(names);
    }

    @Test
    void shouldReturnAnyPlayerAsNextPlayer() {
        String[] names = PlayerNames.generate(NUMBER_OF_PLAYERS);

        Players players = new RandomOrderPlayers(names);

        assertThat(players.isNext(names[0]) || players.isNext(names[1])).isTrue();
    }

    @Test
    void shouldReturnStreamOfPlayerNamesInRandomOrder() {
        String[] names = PlayerNames.generate(NUMBER_OF_PLAYERS);

        Players players = new RandomOrderPlayers(names);

        assertThat(players.streamNames()).containsExactlyInAnyOrder(names);
    }

}
