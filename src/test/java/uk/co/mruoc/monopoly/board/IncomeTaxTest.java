package uk.co.mruoc.monopoly.board;

import org.junit.Test;
import uk.co.mruoc.monopoly.Player;

import static org.assertj.core.api.Assertions.assertThat;

public class IncomeTaxTest {

    private final Location location = new IncomeTax();
    private final Player player = new Player("NAME");

    @Test
    public void shouldReturnName() {
        assertThat(location.getName()).isEqualTo("Income Tax");
    }

    @Test
    public void shouldChargeIncomeTax() {
        player.setBalance(2000);

        location.applyTo(player);

        assertThat(player.getBalance()).isEqualTo(1800);
    }

}
