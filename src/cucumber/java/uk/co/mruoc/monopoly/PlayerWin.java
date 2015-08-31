package uk.co.mruoc.monopoly;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerWin {

    private Game game;

    @Given("^The game is set up with (\\d+) players$")
    public void the_game_is_set_up_with_players(int numberOfPlayers) throws Throwable {
        game = new Game(numberOfPlayers);
    }

    @When("^The first player lands on super tax$")
    public void the_first_player_lands_on_super_tax() throws Throwable {
        game.nextTurn(39);
    }

    @Then("^The second player is the winner$")
    public void the_second_player_is_the_winner() throws Throwable {
        Player winner = game.getWinner();
        assertThat(winner).isEqualTo(game.getPlayer(1));
    }

    @Then("^The other two players continue complete the game$")
    public void the_other_two_players_continue_complete_the_game() throws Throwable {
        game.completeGame();
    }

    @Then("^have played (\\d+) rounds each$")
    public void have_played_rounds_each(int expectedNumberOfRounds) throws Throwable {
        assertThat(game.getPlayer(1).getNumberOfRoundsPlayed()).isEqualTo(expectedNumberOfRounds);
        assertThat(game.getPlayer(2).getNumberOfRoundsPlayed()).isEqualTo(expectedNumberOfRounds);
    }

}
