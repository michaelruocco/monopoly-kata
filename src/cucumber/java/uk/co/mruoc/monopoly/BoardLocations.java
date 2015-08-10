package uk.co.mruoc.monopoly;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardLocations {

    private Board board;

    @When("^A board is created$")
    public void a_board_is_created() throws Throwable {
        board = new Board();
    }

    @Then("^Location (\\d+) is \"(.*?)\"$")
    public void location_is(int position, String expectedName) throws Throwable {
        Location location = board.getLocation(position);
        assertThat(location.getName()).isEqualTo(expectedName);
    }


}
