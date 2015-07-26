package uk.co.mruoc.monopoly;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerMovement {

    private Board board = new Board();
    private Player player = new Player("NAME");

    @Given("^A player is at position (\\d+)$")
    public void a_player_is_at_position(int startPosition) throws Throwable {
        player.setPosition(startPosition);
    }

    @When("^The player rolls a (\\d+)$")
    public void the_player_rolls_a(int roll) throws Throwable {
        board.movePlayer(roll, player);
    }

    @Then("^The player is at position (\\d+)$")
    public void the_player_is_at_position(int endPosition) throws Throwable {
        assertThat(player.getPosition()).isEqualTo(endPosition);
    }

}
