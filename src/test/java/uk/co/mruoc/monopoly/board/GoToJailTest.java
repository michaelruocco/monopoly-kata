package uk.co.mruoc.monopoly.board;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GoToJailTest {

    private final Location location = new GoToJail();

    @Test
    public void shouldReturnName() {
        assertThat(location.getName()).isEqualTo("Go To Jail");
    }

    @Test
    public void shouldReturnCost() {
        assertThat(location.getCost()).isEqualTo(0);
    }

    @Test
    public void shouldReturnIsSuperTaxFalse() {
        assertThat(location.isSuperTax()).isFalse();
    }

    @Test
    public void shouldReturnIsIncomeTaxFalse() {
        assertThat(location.isIncomeTax()).isFalse();
    }

    @Test
    public void shouldReturnIsGoToJailTrue() {
        assertThat(location.isGoToJail()).isTrue();
    }

}
