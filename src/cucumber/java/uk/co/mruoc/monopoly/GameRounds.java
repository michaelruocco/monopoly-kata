package uk.co.mruoc.monopoly;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class GameRounds {

    private Game game;

    @Given("^A game is played$")
    public void a_game_is_played() throws Throwable {
        game = new Game(2);
    }

    @When("^The game is complete$")
    public void the_game_is_complete() throws Throwable {
        game.playFullGame();
    }

    @Then("^There were (\\d+) rounds in total$")
    public void there_were_rounds_in_total(int expectedNumberOfRounds) throws Throwable {
        assertThat(game.getNumberOfRounds()).isEqualTo(expectedNumberOfRounds);
    }

    @Then("^Each player has played (\\d+) rounds$")
    public void each_player_has_played_rounds(int expectedNumberOfRounds) throws Throwable {
        for(int p = 0; p < game.getNumberOfPlayers(); p++) {
            Player player = game.getPlayer(p);
            assertThat(player.getNumberOfRoundsPlayed()).isEqualTo(expectedNumberOfRounds);
        }
    }

    @Then("^The order of the players is the same for each round$")
    public void the_order_of_the_players_is_the_same_for_each_round() throws Throwable {
        assertThat(game.playerOrderIsSameForEveryRound()).isTrue();
    }

}
