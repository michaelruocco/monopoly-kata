package uk.co.mruoc.monopoly;

import org.junit.Test;
import uk.co.mruoc.monopoly.board.Board;
import uk.co.mruoc.monopoly.board.Property;
import uk.co.mruoc.monopoly.board.Location;
import uk.co.mruoc.monopoly.board.TrainStation;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    private static final String NAME = "Horse";

    private final Board board = new Board();
    private final Player player = new Player(NAME, board);

    @Test
    public void startPositionShouldBeZero() {
        assertThat(player.getPosition()).isEqualTo(0);
    }

    @Test
    public void shouldSetPosition() {
        int position = 5;

        player.setPosition(position);

        assertThat(player.getPosition()).isEqualTo(position);
    }

    @Test
    public void shouldReturnName() {
        assertThat(player.getName()).isEqualTo(NAME);
    }

    @Test
    public void shouldReturnTrueIfMatchesPlayerName() {
        assertThat(player.nameIs(NAME)).isTrue();
    }

    @Test
    public void shouldReturnFalseDoesNotMatchPlayerName() {
        assertThat(player.nameIs("NON MATCHING NAME")).isFalse();
    }

    @Test
    public void newPlayerShouldHavePlayedNoRounds() {
        assertThat(player.getNumberOfRoundsPlayed()).isEqualTo(0);
    }

    @Test
    public void numberOfRoundsPlayedShouldIncrementWithEachRoundAdded() {
        player.addRound(new Round());
        player.addRound(new Round());

        assertThat(player.getNumberOfRoundsPlayed()).isEqualTo(2);
    }

    @Test
    public void playerShouldMove() {
        player.move(8);

        assertThat(player.getPosition()).isEqualTo(8);
    }

    @Test
    public void playerLocationShouldRevertBackToZeroAfterPassingGo() {
        player.setPosition(39);

        player.move(6);

        assertThat(player.getPosition()).isEqualTo(5);
    }

    @Test
    public void playerShouldReceiveNoSalaryIfTheyHaveNotPassedGo() {
        player.endTurn();

        assertThat(player.getBalance()).isEqualTo(0);
    }

    @Test
    public void playerShouldReceiveSalaryIfTheyHavePassedGoOnce() {
        int timesPassedGo = 1;
        givenPlayerHasPassedGo(timesPassedGo);

        player.endTurn();

        assertThat(player.getBalance()).isEqualTo(200);
    }

    @Test
    public void playerShouldReceiveMultipleSalariesIfTheyPassGoMoreThanOnce() {
        givenPlayerHasPassedGo(5);

        player.endTurn();

        assertThat(player.getBalance()).isEqualTo(1000);
    }

    @Test
    public void playerShouldGoToJailIfLandsOnGoToJail() {
        givenPlayerLandsOnGoToJail();

        player.endTurn();

        assertThat(player.getPosition()).isEqualTo(board.getJailPosition());
    }

    @Test
    public void shouldDecrementBalance() {
        player.setBalance(100);

        player.decrementBalance(25);

        assertThat(player.getBalance()).isEqualTo(75);
    }

    @Test
    public void shouldIncrementBalance() {
        player.setBalance(100);

        player.incrementBalance(25);

        assertThat(player.getBalance()).isEqualTo(125);
    }

    @Test
    public void shouldOwnProperty() {
        Location location = createLocation();

        player.addProperty(location);

        assertThat(player.ownsProperty(location)).isTrue();
    }

    @Test
    public void shouldOwnPropertyByName() {
        Location location = createLocation();

        player.addProperty(location);

        assertThat(player.ownsProperty(location.getName())).isTrue();
    }

    @Test
    public void playerShouldStillBePlayingIfBalanceIsZeroOrGreater() {
        player.setBalance(0);

        assertThat(player.hasLost()).isFalse();
    }

    @Test
    public void playerShouldLoseIfBalanceIsNegative() {
        player.setBalance(-10);

        assertThat(player.hasLost()).isTrue();
    }

    @Test
    public void shouldReturnNumberOfTrainStationsOwned() {
        Location trainStation1 = new TrainStation("Train Station 1");
        Location trainStation2 = new TrainStation("Train Station 2");

        assertThat(player.getNumberOfTrainStationsOwned()).isEqualTo(0);

        System.out.println("setting owner of train station 1 to player");
        trainStation1.setOwner(player);
        System.out.println("setting owner of train station 2 to player");
        trainStation2.setOwner(player);

        assertThat(player.getNumberOfTrainStationsOwned()).isEqualTo(2);
    }

    private void givenPlayerHasPassedGo(int times) {
        player.move(board.size() * times);
    }

    private void givenPlayerLandsOnGoToJail() {
        int goToJailPosition = 30;
        player.move(goToJailPosition);
    }

    private Location createLocation() {
        return new Property("PROPERTY", 50);
    }

}
