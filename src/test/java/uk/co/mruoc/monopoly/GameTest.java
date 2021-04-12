package uk.co.mruoc.monopoly;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import uk.co.mruoc.monopoly.board.Board;
import uk.co.mruoc.monopoly.players.Players;
import uk.co.mruoc.monopoly.round.Rounds;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class GameTest {

    private final Players players = mock(Players.class);
    private final Board board = mock(Board.class);
    private final Rounds rounds = mock(Rounds.class);

    private final Game game = new Game(players, board, rounds);

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

    @Test
    void startGameShouldAddAllPlayersToBoardWhenGameStarted() {
        Collection<String> names = Arrays.asList("player-name-1", "player-name-2");
        given(players.stream()).willReturn(names.stream());

        game.play();

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(board, times(names.size())).addPlayer(captor.capture());
        assertThat(captor.getAllValues()).containsExactlyInAnyOrderElementsOf(names);
    }

    @Test
    void shouldPlacePlayerOnSetPlayerLocation() {
        String playerName = "player-name";
        int location = 7;

        game.setPlayerLocation(playerName, location);

        verify(board).placePlayer(playerName, location);
    }

    @Test
    void shouldMovePlayerOnPlayTurn() {
        String playerName = "player-name";
        int location = 7;

        game.playTurn(playerName, location);

        verify(board).movePlayer(playerName, location);
    }

    @Test
    void shouldGetGetPlayerLocation() {
        String playerName = "player-name";
        int expectedLocation = 9;
        given(board.getLocation(playerName)).willReturn(expectedLocation);

        int location = game.getPlayerLocation(playerName);

        assertThat(location).isEqualTo(expectedLocation);
    }

    @Test
    void shouldCreateGameWithPlayerNames() {
        String playerName1 = "player-name-1";
        String playerName2 = "player-name-2";

        Game playerNameGame = new Game(playerName1, playerName2);

        assertThat(playerNameGame.getNumberOfPlayers()).isEqualTo(2);
        assertThat(playerNameGame.hasPlayer(playerName1)).isTrue();
        assertThat(playerNameGame.hasPlayer(playerName2)).isTrue();
    }

    @Test
    void shouldReturnNumberOfRoundsPlayed() {
        long expectedNumberOfRoundsPlayed = 5;
        given(rounds.getNumberOfRoundsPlayed()).willReturn(expectedNumberOfRoundsPlayed);

        long numberOfRoundsPlayed = game.getNumberOfRoundsPlayed();

        assertThat(numberOfRoundsPlayed).isEqualTo(expectedNumberOfRoundsPlayed);
    }

    @Test
    void shouldReturnNumberOfRoundsPlayedByPlayer() {
        String playerName = "player-name";
        long expectedNumberOfRoundsPlayed = 5;
        given(rounds.getNumberOfRoundsPlayedBy(playerName)).willReturn(expectedNumberOfRoundsPlayed);

        long numberOfRoundsPlayed = game.getNumberOfRoundsPlayedBy(playerName);

        assertThat(numberOfRoundsPlayed).isEqualTo(expectedNumberOfRoundsPlayed);
    }

    @Test
    void shouldReturnPlayerOrderIsTheSameForEveryRound() {
        given(rounds.allHavePlayersInSameOrder()).willReturn(true);

        boolean playerOrderIsSame = game.playerOrderIsTheSameForEveryRound();

        assertThat(playerOrderIsSame).isTrue();
    }

}