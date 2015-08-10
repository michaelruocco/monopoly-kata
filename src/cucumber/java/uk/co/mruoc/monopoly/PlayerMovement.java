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

    @Given("^has an initial balance of (\\d+)$")
    public void has_an_initial_balance_of(double balance) throws Throwable {
        player.setBalance(balance);
    }

    @When("^The player rolls a (\\d+)$")
    public void the_player_rolls_a(int roll) throws Throwable {
        board.movePlayer(roll, player);
    }

    @Then("^The player is at position (\\d+)$")
    public void the_player_is_at_position(int endPosition) throws Throwable {
        assertThat(player.getPosition()).isEqualTo(endPosition);
    }

    @Then("^The player is on \"(.*?)\"$")
    public void the_player_is_on(String expectedLocationName) throws Throwable {
        Location location = board.getLocation(player.getPosition());
        assertThat(location.getName()).isEqualTo(expectedLocationName);
    }

    @Then("^The player has a balance of (\\d+)$")
    public void the_player_has_a_balance_of(double expectedBalance) throws Throwable {
        assertThat(player.getBalance()).isEqualTo(expectedBalance);
    }

}
