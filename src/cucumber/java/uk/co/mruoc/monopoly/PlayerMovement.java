package uk.co.mruoc.monopoly;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerMovement {

    private Game game = new Game(2);
    private Board board = new Board();
    private Player player = game.getPlayer(0);

    @Given("^A player starts a turn on \"(.*?)\" with a balance of (\\d+)$")
    public void a_player_starts_a_turn_on_with_a_balance_of(String locationName, double balance) throws Throwable {
        int locationPosition = board.getLocationPosition(locationName);
        player.setPosition(locationPosition);
        player.setBalance(balance);
    }

    @Given("^has an initial balance of (\\d+)$")
    public void has_an_initial_balance_of(double balance) throws Throwable {
        player.setBalance(balance);
    }

    @When("^The player rolls a (\\d+)$")
    public void the_player_rolls_a(int roll) throws Throwable {
        game.move(player, roll);
    }

    @Then("^The player is at position (\\d+)$")
    public void the_player_is_at_position(int endPosition) throws Throwable {
        assertThat(player.getPosition()).isEqualTo(endPosition);
    }

    @Then("^The player ends the turn on \"(.*?)\"$")
    public void the_player_ends_the_turn_on(String expectedLocationName) throws Throwable {
        String locationName = board.getLocationName(player);
        assertThat(locationName).isEqualTo(expectedLocationName);
    }

    @Then("^The player has a balance of (\\d+)$")
    public void the_player_has_a_balance_of(double expectedBalance) throws Throwable {
        assertThat(player.getBalance()).isEqualTo(expectedBalance);
    }

}
