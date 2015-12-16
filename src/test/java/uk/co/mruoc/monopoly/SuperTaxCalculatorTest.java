package uk.co.mruoc.monopoly;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SuperTaxCalculatorTest {

    private static final int SUPER_TAX_CHARGE = 75;

    private final SuperTaxCalculator calculator = new SuperTaxCalculator();

    @Test
    public void shouldCalculateSuperTaxCharge() {
        assertThat(calculator.calculateCharge()).isEqualTo(SUPER_TAX_CHARGE);
    }

}
