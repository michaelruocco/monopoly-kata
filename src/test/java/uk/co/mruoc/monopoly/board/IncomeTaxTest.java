package uk.co.mruoc.monopoly.board;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IncomeTaxTest {

    private final Location location = new IncomeTax();

    @Test
    public void shouldReturnName() {
        assertThat(location.getName()).isEqualTo("Income Tax");
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
    public void shouldReturnIsIncomeTaxTrue() {
        assertThat(location.isIncomeTax()).isTrue();
    }

    @Test
    public void shouldReturnIsGoToJailFalse() {
        assertThat(location.isGoToJail()).isFalse();
    }

}
