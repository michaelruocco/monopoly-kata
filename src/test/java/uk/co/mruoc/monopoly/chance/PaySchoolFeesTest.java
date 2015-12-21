package uk.co.mruoc.monopoly.chance;

import org.junit.Test;
import uk.co.mruoc.monopoly.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class PaySchoolFeesTest {

    private final ChanceCard chanceCard = new PaySchoolFees();
    private final Player player = new Player("NAME");

    @Test
    public void playerShouldPaySchoolFees() {
        player.setBalance(200);

        chanceCard.applyTo(player);

        assertThat(player.getBalance()).isEqualTo(50);
    }

    @Test
    public void shouldReturnText() {
        assertThat(chanceCard.getText()).isEqualTo("Pay school fees of £150");
    }

}
