package uk.co.mruoc.monopoly;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameSteps {

    private final Collection<String> players = new ArrayList<>();
    private final Collection<Game> games = new ArrayList<>();
    private Game game;
    private String errorMessage;

    @Given("a player {string}")
    public void aPlayer(String name) {
        players.add(name);
    }

    @Given("player {string} starts at location {int}")
    public void setPlayerLocation(String playerName, int location) {
        game.setPlayerLocation(playerName, location);
    }

    @Given("player {string} starts at location {string}")
    public void player_starts_at_location(String playerName, String locationName) {
        game.setPlayerLocation(playerName, locationName);
    }

    @When("{int} games are created")
    public void gamesAreCreated(int numberOfGamesToCreate) {
        IntStream.range(0, numberOfGamesToCreate).forEach(g -> createGame());
    }

    @When("the game is created")
    public void createGame() {
        try {
            game = new Game(players);
            games.add(game);
        } catch (MonopolyException e) {
            errorMessage = e.getMessage();
        }
    }

    @When("the game is played")
    public void playGame() {
        game.play();
    }

    @When("player {string} rolls {int}")
    public void playerRolls(String name, int rolled) {
        game.playTurn(name, rolled);
    }

    @Then("One of the players is {string}")
    public void oneOfThePlayersIs(String name) {
        assertThat(game.hasPlayer(name)).isTrue();
    }

    @Then("An error occurred with the message {string}")
    public void anErrorOccurredWithTheMessage(String expectedErrorMessage) {
        assertThat(errorMessage).isEqualTo(expectedErrorMessage);
    }

    @Then("{string} is the first player at least once")
    public void isTheFirstPlayerAtLeastOnce(String name) {
        assertThat(games.stream().anyMatch(game -> game.isNextPlayer(name))).isTrue();
    }

    @Then("player {string} is at location {string}")
    public void assertPlayerLocation(String playerName, String locationName) {
        assertThat(game.getPlayerLocationName(playerName)).isEqualTo(locationName);
    }

    @Then("player {string} is at location {int}")
    public void assertPlayerLocation(String playerName, int location) {
        assertThat(game.getPlayerLocation(playerName)).isEqualTo(location);
    }

    @Then("{int} rounds have been played in total")
    public void roundsHaveBeenPlayedInTotal(int expectedNumberOfRounds) {
        assertThat(game.getNumberOfRoundsPlayed()).isEqualTo(expectedNumberOfRounds);
    }

    @Then("{string} has played {int} rounds")
    public void hasPlayedRounds(String name, int expectedNumberOfRounds) {
        assertThat(game.getNumberOfRoundsPlayedBy(name)).isEqualTo(expectedNumberOfRounds);
    }

    @Then("the order of the players is the same in every round")
    public void theOrderOfThePlayersIsTheSameInEveryRound() {
        assertThat(game.playerOrderIsTheSameForEveryRound()).isTrue();
    }

}
