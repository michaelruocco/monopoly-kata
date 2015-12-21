package uk.co.mruoc.monopoly.chance;

import org.junit.Test;
import uk.co.mruoc.monopoly.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class BuildingLoanTest {

    private final ChanceCard chanceCard = new BuildingLoan();
    private final Player player = new Player("NAME");

    @Test
    public void shouldPayPlayerOneHundredAndFifty() {
        player.setBalance(0);

        chanceCard.applyTo(player);

        assertThat(player.getBalance()).isEqualTo(150);
    }

    @Test
    public void shouldReturnText() {
        assertThat(chanceCard.getText()).isEqualTo("Your building loan matures. Receive £150");
    }

}
