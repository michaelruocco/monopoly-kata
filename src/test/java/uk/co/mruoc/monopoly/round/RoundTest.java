package uk.co.mruoc.monopoly.round;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTest {

    private static final int NUMBER = 2;

    private final Round round = new Round(NUMBER);

    @Test
    void shouldReturnRoundNumber() {
        assertThat(round.getNumber()).isEqualTo(NUMBER);
    }

    @Test
    void shouldReturnFalseIfDoesNotContainPlayer() {
        String name = "player-name";

        boolean contains = round.containsPlayer(name);

        assertThat(contains).isFalse();
    }

    @Test
    void shouldReturnTrueIfContainsPlayer() {
        String name = "player-name";
        round.addPlayer(name);

        boolean contains = round.containsPlayer(name);

        assertThat(contains).isTrue();
    }

    @Test
    void shouldReturnTrueIfOtherRoundContainsSamePlayers() {
        String name = "player-name";
        round.addPlayer(name);
        Round otherRound = new Round(NUMBER);
        otherRound.addPlayer(name);

        boolean samePlayerOrder = round.hasSamePlayerOrder(otherRound);

        assertThat(samePlayerOrder).isTrue();
    }

    @Test
    void shouldReturnFalseIfOtherRoundDoesNotContainSamePlayerInSameOrder() {
        String playerName1 = "player-name-1";
        String playerName2 = "player-name-2";
        round.addPlayer(playerName1);
        round.addPlayer(playerName2);
        Round otherRound = new Round(NUMBER);
        otherRound.addPlayer(playerName2);
        otherRound.addPlayer(playerName1);

        boolean samePlayerOrder = round.hasSamePlayerOrder(otherRound);

        assertThat(samePlayerOrder).isFalse();
    }

}