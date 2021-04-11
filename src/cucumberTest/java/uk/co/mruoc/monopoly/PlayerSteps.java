package uk.co.mruoc.monopoly;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerSteps {

    private int numberOfPlayers;
    private Game game;
    private Collection<Game> games = new ArrayList<>();
    private String errorMessage;

    @Given("{int} player")
    public void player(int numberOfPlayers) {
        players(numberOfPlayers);
    }

    @Given("{int} players")
    public void players(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    @When("{int} games are started")
    public void gamesAreStarted(int numberOfGamesToStart) {
        IntStream.range(0, numberOfGamesToStart).forEach(g -> startGame());
    }

    @When("the game is started")
    public void startGame() {
        try {
            game = new Game(numberOfPlayers);
            game.start();

            games.add(game);
        } catch (InvalidNumberOfPlayersException e) {
            errorMessage = e.getMessage();
        }
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
        assertThat(games.stream().anyMatch(game -> game.hasFirstPlayer(name))).isTrue();
    }

}
