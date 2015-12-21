package uk.co.mruoc.monopoly;

import org.junit.Test;
import uk.co.mruoc.monopoly.board.*;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    private static final int ROLL = 1;
    private static final String NAME = "Horse";

    private final Board board = new Board();
    private final PropertyGroup group = new PropertyGroup();
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
        player.endTurn(ROLL);

        assertThat(player.getBalance()).isEqualTo(0);
    }

    @Test
    public void playerShouldReceiveSalaryIfTheyHavePassedGoOnce() {
        int timesPassedGo = 1;
        givenPlayerHasPassedGo(timesPassedGo);

        player.endTurn(ROLL);

        assertThat(player.getBalance()).isEqualTo(200);
    }

    @Test
    public void playerShouldReceiveMultipleSalariesIfTheyPassGoMoreThanOnce() {
        givenPlayerHasPassedGo(5);

        player.endTurn(ROLL);

        assertThat(player.getBalance()).isEqualTo(1000);
    }

    @Test
    public void playerShouldGoToJailIfLandsOnGoToJail() {
        givenPlayerLandsOnGoToJail();

        player.endTurn(ROLL);

        assertThat(player.isInJail()).isTrue();
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
    public void shouldReturnTrueIfPlayerCanAffordProperty() {
        Property property = new Street("Name", group, 50, 0);

        player.setBalance(50);

        assertThat(player.canAfford(property)).isTrue();
    }

    @Test
    public void shouldReturnFalseIfPlayerCannotAffordProperty() {
        Property property = new Street("Name", group, 50, 0);

        player.setBalance(0);

        assertThat(player.canAfford(property)).isFalse();
    }

    @Test
    public void shouldMoveToJail() {
        player.goToJail();

        assertThat(player.isInJail()).isTrue();
    }

    private void givenPlayerHasPassedGo(int times) {
        player.move(board.size() * times);
    }

    private void givenPlayerLandsOnGoToJail() {
        int goToJailPosition = 30;
        player.move(goToJailPosition);
    }

}
