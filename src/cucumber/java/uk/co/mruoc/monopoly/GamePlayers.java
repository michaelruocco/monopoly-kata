package uk.co.mruoc.monopoly;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.co.mruoc.monopoly.board.Board;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GamePlayers {

    private List<Player> firstPlayers = new ArrayList<>();
    private Players players;
    private String errorMessage;

    @When("^A game is set up with (\\d+) players$")
    public void a_game_is_set_up_with_players(int numberOfPlayers) throws Throwable {
        createGame(numberOfPlayers);
    }

    @When("^A game is set up with one player$")
    public void a_game_is_set_up_with_one_player() throws Throwable {
        createGame(1);
    }

    @When("^(\\d+) games are created with (\\d+) players$")
    public void games_are_created_with_players(int numberOfGames, int numberOfPlayers) throws Throwable {
        for(int g = 0; g < numberOfGames; g++) {
            createGame(numberOfPlayers);
            firstPlayers.add(players.getPlayer(0));
        }
    }

    @Then("^The game has (\\d+) players$")
    public void the_game_has_players(int numberOfPlayers) throws Throwable {
        assertThat(players.getNumberOfPlayers()).isEqualTo(numberOfPlayers);
    }

    @Then("^One of the players is \"(.*?)\"$")
    public void one_of_the_players_is(String expectedName) throws Throwable {
        assertThat(players.exists(expectedName));
    }

    @Then("^An error is thrown with the message \"(.*?)\"$")
    public void an_error_is_thrown_with_the_message(String expectedErrorMessage) throws Throwable {
        assertThat(errorMessage).isEqualTo(expectedErrorMessage);
    }

    @Then("^\"(.*?)\" is the first player at least once$")
    public void is_the_first_player_at_least_once(String expectedName) throws Throwable {
        assertThat(isFirstPlayerAtLeastOnce(expectedName)).isTrue();
    }

    private boolean isFirstPlayerAtLeastOnce(String name) {
        for(Player firstPlayer : firstPlayers)
            if (firstPlayer.nameIs(name))
                return true;
        return false;
    }

    private void createGame(int numberOfPlayers) {
        try {
            players = new Players(numberOfPlayers, new Board());
        } catch (GameException e) {
            errorMessage = e.getMessage();
        }
    }

}
