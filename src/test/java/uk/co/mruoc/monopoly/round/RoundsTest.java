package uk.co.mruoc.monopoly.round;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoundsTest {

    private final Rounds rounds = new Rounds();

    @Test
    void shouldReturnTwentyRoundsByDefault() {
        assertThat(rounds.getNumberOfRounds()).isEqualTo(20);
    }

    @Test
    void shouldHavePlayedZeroRoundsByDefault() {
        assertThat(rounds.getNumberOfRoundsPlayed()).isZero();
    }

    @Test
    void shouldIncrementNumberOfRoundsPlayedWhenNextRoundStarted() {
        rounds.startNextRound();
        rounds.startNextRound();

        assertThat(rounds.getNumberOfRoundsPlayed()).isEqualTo(2);
    }

    @Test
    void shouldReturnNumberOfRoundsPlayedByPlayer() {
        String player1Name = "player-1-name";
        String player2Name = "player-2-name";
        Round round1 = rounds.startNextRound();
        round1.addPlayer(player1Name);
        Round round2 = rounds.startNextRound();
        round2.addPlayer(player1Name);

        assertThat(rounds.getNumberOfRoundsPlayedBy(player1Name)).isEqualTo(2);
        assertThat(rounds.getNumberOfRoundsPlayedBy(player2Name)).isZero();
    }

    @Test
    void shouldReturnTrueIfAllRoundsHaveSamePlayersInSameOrder() {
        String player1Name = "player-1-name";
        String player2Name = "player-2-name";
        Round round1 = rounds.startNextRound();
        round1.addPlayer(player1Name);
        round1.addPlayer(player2Name);
        Round round2 = rounds.startNextRound();
        round2.addPlayer(player1Name);
        round2.addPlayer(player2Name);

        assertThat(rounds.allHavePlayersInSameOrder()).isTrue();
    }

    @Test
    void shouldReturnFalseIfAllRoundsDoNotHaveSamePlayersInSameOrder() {
        String player1Name = "player-1-name";
        String player2Name = "player-2-name";
        Round round1 = rounds.startNextRound();
        round1.addPlayer(player2Name);
        round1.addPlayer(player1Name);
        Round round2 = rounds.startNextRound();
        round2.addPlayer(player1Name);
        round2.addPlayer(player2Name);

        assertThat(rounds.allHavePlayersInSameOrder()).isFalse();
    }

}