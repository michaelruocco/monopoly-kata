package uk.co.mruoc.monopoly;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uk.co.mruoc.monopoly.board.Board;
import uk.co.mruoc.monopoly.board.Property;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerWin {

    private Board board = new Board();
    private Players players;
    private Game game;

    @Given("^The game is set up with (\\d+) players$")
    public void the_game_is_set_up_with_players(int numberOfPlayers) throws Throwable {
        players = new Players(numberOfPlayers, board);
        game = new Game(players);
    }

    @Given("^Player (\\d+) starts with a balance of (\\d+)$")
    public void player_starts_with_a_balance_of(int playerNumber, int balance) throws Throwable {
        Player player = getPlayer(playerNumber);
        player.setBalance(balance);
    }

    @Given("^Player (\\d+) owns \"([^\"]*)\"$")
    public void player_owns(int playerNumber, String propertyName) throws Throwable {
        Player player = getPlayer(playerNumber);
        Property property = board.getProperty(propertyName);
        property.setOwner(player);
    }

    @When("^Player (\\d+) lands on \"(.*?)\"$")
    public void player_lands_on(int playerNumber, String locationName) throws Throwable {
        int position = board.getLocationPosition(locationName);
        Player player = getPlayer(playerNumber);
        game.move(player, position);
    }

    @When("^Player (\\d+) lands on \"([^\"]*)\" and has rolled a (\\d+)$")
    public void player_lands_on_and_has_rolled_a(int playerNumber, String locationName, int roll) throws Throwable {
        int position = board.getLocationPosition(locationName);
        Player player = getPlayer(playerNumber);
        game.move(player, position);
    }

    @Then("^Player (\\d+) has a balance of (-?\\d+)$")
    public void player_has_a_balance_of(int playerNumber, int expectedBalance) throws Throwable {
        Player player = getPlayer(playerNumber);
        assertThat(player.getBalance()).isEqualTo(expectedBalance);
    }

    @Then("^Player (\\d+) is the winner$")
    public void player_is_the_winner(int playerNumber) throws Throwable {
        Player winner = players.getWinner();
        Player player = getPlayer(playerNumber);
        assertThat(player).isEqualTo(winner);
    }

    @Then("^The other players continue complete the game$")
    public void the_other_players_continue_complete_the_game() throws Throwable {
        game.play(10);
    }

    @Then("^Have played (\\d+) rounds$")
    public void have_played_rounds(int expectedNumberOfRounds) throws Throwable {
        List<Player> remainingPlayers = players.getRemainingPlayers();
        for (Player player : remainingPlayers)
            assertThat(player.getNumberOfRoundsPlayed()).isEqualTo(expectedNumberOfRounds);
    }

    @Then("^Player (\\d+) has to pay (\\d+) in rent to player (\\d+)$")
    public void player_has_to_pay_in_rent_to_player(int  playerNumber1, int rent, int playerNumber2) throws Throwable {
        //intentionally blank
    }

    private Player getPlayer(int playerNumber) {
        return players.getPlayer(playerNumber - 1);
    }

}
