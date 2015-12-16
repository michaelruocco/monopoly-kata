package uk.co.mruoc.monopoly;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Pl;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerWin {

    private Board board = new Board();
    private Players players;
    private Game game;

    @Given("^The game is set up with (\\d+) players$")
    public void the_game_is_set_up_with_players(int numberOfPlayers) throws Throwable {
        players = new Players(numberOfPlayers, board);
        game = new Game(players);
    }

    @When("^Player (\\d+) lands on \"(.*?)\"$")
    public void player_lands_on(int playerNumber, String locationName) throws Throwable {
        int position = board.getLocationPosition(locationName);
        Player firstPlayer = players.getPlayer(playerNumber - 1);
        game.move(firstPlayer, position);
    }

    @Then("^Player (\\d+) has a balance of (-?\\d+)$")
    public void player_has_a_balance_of(int playerNumber, int expectedBalance) throws Throwable {
        Player player = getPlayer(playerNumber);
        assertThat(player.getBalance()).isEqualTo(expectedBalance);
    }

    @Then("^Player (\\d+) is the winner$")
    public void player_is_the_winner(int playerNumber) throws Throwable {
        Player winner = game.getWinner();
        Player player = getPlayer(playerNumber);
        assertThat(player).isEqualTo(winner);
    }

    @Then("^The other players continue complete the game$")
    public void the_other_players_continue_complete_the_game() throws Throwable {
        game.completeGame();
    }

    @Then("^Have played (\\d+) rounds$")
    public void have_played_rounds(int expectedNumberOfRounds) throws Throwable {
        List<Player> remainingPlayers = players.getRemainingPlayers();
        for (Player player : remainingPlayers)
            assertThat(player.getNumberOfRoundsPlayed()).isEqualTo(expectedNumberOfRounds);
    }

    private Player getPlayer(int playerNumber) {
        return players.getPlayer(playerNumber - 1);
    }

}
