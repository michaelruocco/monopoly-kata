package uk.co.mruoc.monopoly;

import org.junit.jupiter.api.Test;
import uk.co.mruoc.monopoly.players.Players;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class GameTest {

    private final Players players = mock(Players.class);

    private final Game game = new Game(players);

    @Test
    void shouldReturnHasPlayer() {
        String playerName = "player-name-1";
        given(players.contains(playerName)).willReturn(true);

        boolean present = game.hasPlayer(playerName);

        assertThat(present).isTrue();
    }

    @Test
    void shouldReturnIsNextPlayer() {
        String playerName = "player-name-2";
        given(players.isNext(playerName)).willReturn(true);

        boolean next = game.isNextPlayer(playerName);

        assertThat(next).isTrue();
    }

}