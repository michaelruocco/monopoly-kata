package uk.co.mruoc.monopoly;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.co.mruoc.monopoly.board.Property;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerMovement {

    private final uk.co.mruoc.monopoly.board.Board board = new uk.co.mruoc.monopoly.board.Board();
    private final Players players = new Players(2, board);
    private final Game game = new Game(players);
    private final Player player = players.getPlayer(0);

    @Given("^A player starts a turn on \"(.*?)\" with a balance of (\\d+)$")
    public void a_player_starts_a_turn_on_with_a_balance_of(String locationName, double balance) throws Throwable {
        setPlayerLocation(locationName);
        player.setBalance(balance);
    }

    @Given("^has an initial balance of (\\d+)$")
    public void has_an_initial_balance_of(double balance) throws Throwable {
        player.setBalance(balance);
    }

    @Given("^A player starts a turn on \"(.*?)\"$")
    public void a_player_starts_a_turn_on(String locationName) throws Throwable {
        setPlayerLocation(locationName);
    }

    @Given("^A player owns \"(.*?)\"$")
    public void a_player_owns(String propertyName) throws Throwable {
        Property property = board.getProperty(propertyName);
        property.setOwner(player);
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

    @Then("^The player owns \"(.*?)\"$")
    public void the_player_owns(String expectedPropertyName) throws Throwable {
        Property property = board.getProperty(expectedPropertyName);
        assertThat(property.ownedBy(player)).isTrue();
    }

    private void setPlayerLocation(String locationName) {
        int locationPosition = board.getLocationPosition(locationName);
        player.setPosition(locationPosition);
    }

}
