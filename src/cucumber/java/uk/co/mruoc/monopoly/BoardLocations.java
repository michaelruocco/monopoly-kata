package uk.co.mruoc.monopoly;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardLocations {

    private uk.co.mruoc.monopoly.board.Board board;

    @When("^A board is created$")
    public void a_board_is_created() throws Throwable {
        board = new uk.co.mruoc.monopoly.board.Board();
    }

    @Then("^location (\\d+) is \"(.*?)\"$")
    public void location_is(int position, String expectedName) throws Throwable {
        String locationName = board.getLocationName(position);
        assertThat(locationName).isEqualTo(expectedName);
    }


}
