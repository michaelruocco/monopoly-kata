package uk.co.mruoc.monopoly;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import uk.co.mruoc.monopoly.board.Board;
import uk.co.mruoc.monopoly.board.Location;
import uk.co.mruoc.monopoly.players.Player;
import uk.co.mruoc.monopoly.players.Players;
import uk.co.mruoc.monopoly.round.Round;
import uk.co.mruoc.monopoly.round.Rounds;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;
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
        given(players.streamNames()).willReturn(names.stream());

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
    void shouldPlacePlayerOnSetPlayerLocationName() {
        String playerName = "player-name";
        String locationName = "location-name";

        game.setPlayerLocation(playerName, locationName);

        verify(board).placePlayer(playerName, locationName);
    }

    @Test
    void shouldMovePlayerOnPlayTurn() {
        String playerName = "player-name";
        int roll = 7;
        givenLandsOnLocation(playerName, roll);

        game.playTurn(playerName, roll);

        verify(board).movePlayer(playerName, roll);
    }

    @Test
    void shouldLandPlayerLocation() {
        String playerName = "player-name";
        int roll = 7;
        Location location = givenLandsOnLocation(playerName, roll);
        Player player = givenPlayerFound(playerName);

        game.playTurn(playerName, roll);

        verify(location).land(player);
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
    void shouldGetGetPlayerLocationName() {
        String playerName = "player-name";
        String expectedLocationName = "location-name";
        given(board.getLocationName(playerName)).willReturn(expectedLocationName);

        String locationName = game.getPlayerLocationName(playerName);

        assertThat(locationName).isEqualTo(expectedLocationName);
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

    @Test
    void shouldPlayAllRoundsOfGame() {
        String playerName1 = "player-name-1";
        String playerName2 = "player-name-2";
        given(players.streamNames()).willReturn(Stream.of(playerName1, playerName2));
        given(players.getNextPlayerName()).willReturn(playerName1, playerName2);
        given(players.isFirstPlayerNext()).willReturn(false, true);
        int numberOfRounds = 1;
        given(rounds.getNumberOfRounds()).willReturn(numberOfRounds);
        Round round = mock(Round.class);
        given(rounds.startNextRound()).willReturn(round);

        game.play();

        InOrder inOrder = inOrder(round, players);
        inOrder.verify(round).addPlayer(playerName1);
        inOrder.verify(round).addPlayer(playerName2);
        inOrder.verify(players).updateNextPlayer();
    }

    @Test
    void shouldReturnPlayerBalance() {
        String name = "player-name";
        BigDecimal expectedBalance = BigDecimal.TEN;
        given(players.getBalance(name)).willReturn(expectedBalance);

        BigDecimal balance = game.getPlayerBalance(name);

        assertThat(balance).isEqualTo(expectedBalance);
    }

    private Location givenLandsOnLocation(String playerName, int roll) {
        Location location = mock(Location.class);
        given(board.movePlayer(playerName, roll)).willReturn(location);
        return location;
    }

    private Player givenPlayerFound(String name) {
        Player player = mock(Player.class);
        given(players.forceFind(name)).willReturn(player);
        return player;
    }

}