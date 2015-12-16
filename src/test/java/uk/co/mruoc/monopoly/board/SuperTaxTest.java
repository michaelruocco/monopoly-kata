package uk.co.mruoc.monopoly.board;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SuperTaxTest {

    private final Location location = new SuperTax();

    @Test
    public void shouldReturnName() {
        assertThat(location.getName()).isEqualTo("Super Tax");
    }

    @Test
    public void shouldReturnCost() {
        assertThat(location.getCost()).isEqualTo(0);
    }

    @Test
    public void shouldReturnIsSuperTaxTrue() {
        assertThat(location.isSuperTax()).isTrue();
    }

    @Test
    public void shouldReturnIsIncomeTaxFalse() {
        assertThat(location.isIncomeTax()).isFalse();
    }

    @Test
    public void shouldReturnIsGoToJailFalse() {
        assertThat(location.isGoToJail()).isFalse();
    }

}
