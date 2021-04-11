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
    public void setPlayerLocation(String name, int location) {
        game.setPlayerLocation(name, location);
    }

    @When("{int} games are started")
    public void gamesAreStarted(int numberOfGamesToStart) {
        IntStream.range(0, numberOfGamesToStart).forEach(g -> startGame());
    }

    @When("the game is started")
    public void startGame() {
        try {
            game = new Game(players);
            game.start();

            games.add(game);
        } catch (MonopolyException e) {
            errorMessage = e.getMessage();
        }
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

    @Then("player {string} is at location {int}")
    public void assertPlayerLocation(String name, int location) {
        assertThat(game.getPlayerLocation(name)).isEqualTo(location);
    }

}
