package uk.co.mruoc.monopoly;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class PropertyPurchase {

    private static final int PASS_GO_SALARY = 200;

    private Game game = new Game(2, new uk.co.mruoc.monopoly.board.Board());
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
        game.nextTurn(3);
    }

    @Given("^The players balance has changed to (\\d+)$")
    public void the_players_balance_has_changed_to(double expectedBalance) throws Throwable {
        balance = expectedBalance;
        assertThat(player.getBalance()).isEqualTo(expectedBalance);
    }

    @When("^The player moves (\\d+) places$")
    public void the_player_moves_places(int places) throws Throwable {
        game.nextTurn(places);
    }

    @When("^The player passes go and lands on that property again$")
    public void the_player_passes_go_and_lands_on_that_property_again() throws Throwable {
        game.nextTurn(40);
        game.nextTurn(40);
        balance += PASS_GO_SALARY;
    }

    @When("^The passes over an unowned property$")
    public void the_passes_over_an_unowned_property() throws Throwable {
        game.nextTurn(3);
    }

    @Then("^The the players balance remains unchanged$")
    public void the_the_players_balance_remains_unchanged() throws Throwable {
        assertThat(player.getBalance()).isEqualTo(balance);
    }

}
