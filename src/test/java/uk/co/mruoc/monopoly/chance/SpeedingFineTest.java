package uk.co.mruoc.monopoly.chance;

import org.junit.Test;
import uk.co.mruoc.monopoly.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class SpeedingFineTest {

    private final ChanceCard chanceCard = new SpeedingFine();
    private final Player player = new Player("NAME");

    @Test
    public void shouldFinePlayerFifteen() {
        player.setBalance(20);

        chanceCard.applyTo(player);

        assertThat(player.getBalance()).isEqualTo(5);
    }

    @Test
    public void shouldReturnText() {
        assertThat(chanceCard.getText()).isEqualTo("Spending fine £15");
    }

}
