package uk.co.mruoc.monopoly;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test(expected = MonopolyException.class)
    public void shouldThrowExceptionIfLessThanTwoPlayers() {
        new Game(1);
    }

    @Test(expected = MonopolyException.class)
    public void shouldThrowExceptionIfMoreThanEightPlayers() {
        new Game(9);
    }

    @Test
    public void playersShouldBeHorseAndCar() {
        Game game = new Game(2);

        assertThat(game.getNumberOfPlayers()).isEqualTo(2);
        assertThat(game.playerExists("Horse")).isTrue();
        assertThat(game.playerExists("Car")).isTrue();
    }

    @Test
    public void gameShouldLastForTwentyRounds() {
        Game game = new Game(2);

        game.play();

        assertThat(game.getNumberOfRounds()).isEqualTo(20);
    }

    @Test
    public void playerOrderShouldBeTheSameForEveryRound() {
        Game game = new Game(2);

        game.play();

        assertThat(game.playerOrderIsSameForEveryRound()).isTrue();
    }

}
