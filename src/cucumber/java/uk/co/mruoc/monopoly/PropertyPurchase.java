package uk.co.mruoc.monopoly;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class PropertyPurchase {

    private Game game = new Game(2);
    private Player player = game.getPlayer(0);

    private double balance;

    @Given("^A player has a balance of (\\d+)$")
    public void a_player_has_a_balance_of(int balance) throws Throwable {
        this.balance = balance;
        player.setBalance(balance);
    }

    @Given("^The player has brought a property$")
    public void the_player_has_brought_a_property() throws Throwable {
        game.nextTurn(4);
        //get value after purchasing property and add 200 for passing go
        balance = player.getBalance() + 200;
        game.nextTurn(3);
    }

    @When("^The player moves (\\d+) places$")
    public void the_player_moves_places(int places) throws Throwable {
        game.nextTurn(places);
    }

    @When("^The player lands on that property again$")
    public void the_player_lands_on_that_property_again() throws Throwable {
        game.nextTurn(40);
        game.nextTurn(40);
    }

    @When("^The passes over an unowned property$")
    public void the_passes_over_an_unowned_property() throws Throwable {
        game.nextTurn(3);
    }

    @Then("^The player owns \"(.*?)\"$")
    public void the_player_owns(String expectedPropertyName) throws Throwable {
        assertThat(player.ownsProperty(expectedPropertyName)).isTrue();
    }

    @Then("^The player balance has decreased by the cost of the property$")
    public void the_player_balance_has_decreased_by_the_cost_of_the_property() throws Throwable {
        Location location = game.getLocation(player);
        assertThat(player.getBalance()).isEqualTo(balance - location.getCost());
    }

    @Then("^The the players balance remains unchanged$")
    public void the_the_players_balance_remains_unchanged() throws Throwable {
        assertThat(player.getBalance()).isEqualTo(balance);
    }

}
