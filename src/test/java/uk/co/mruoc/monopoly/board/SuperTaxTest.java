package uk.co.mruoc.monopoly.board;

import org.junit.Test;
import uk.co.mruoc.monopoly.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class SuperTaxTest {

    private final Location location = new SuperTax();
    private final Player player = new Player("NAME");

    @Test
    public void shouldReturnName() {
        assertThat(location.getName()).isEqualTo("Super Tax");
    }

    @Test
    public void shouldReturnIsGoToJailFalse() {
        assertThat(location.isGoToJail()).isFalse();
    }

    @Test
    public void shouldChargeSuperTax() {
        player.setBalance(100);

        location.applyTo(player);

        assertThat(player.getBalance()).isEqualTo(25);
    }

}
