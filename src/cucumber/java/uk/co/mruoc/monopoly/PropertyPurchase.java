package uk.co.mruoc.monopoly;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class PropertyPurchase {

    private Game game = new Game(2);

    private int balance;
    private int propertyCost;

    @Given("^A player has a balance of (\\d+)$")
    public void a_player_has_a_balance_of(int balance) throws Throwable {
        this.balance = balance;
        Player player = game.getPlayer(0);
        player.setBalance(balance);
    }

    @When("^The player moves (\\d+) places$")
    public void the_player_moves_places(int places) throws Throwable {
        game.nextTurn(places);
    }

    @Then("^The player owns \"(.*?)\"$")
    public void the_player_owns(String expectedPropertyName) throws Throwable {
        Player player = game.getPlayer(0);
        assertThat(player.ownsProperty(expectedPropertyName)).isTrue();
    }

    @Then("^The player balance has decreased by the cost of the property$")
    public void the_player_balance_has_decreased_by_the_cost_of_the_property() throws Throwable {
        Player player = game.getPlayer(0);
        Location location = game.getLocation(player);
        assertThat(player.getBalance()).isEqualTo(balance - location.getCost());
    }

}
