package uk.co.mruoc.monopoly;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IncomeTaxCalculatorTest {

    private final IncomeTaxCalculator calculator = new IncomeTaxCalculator();
    private final Player player = new Player("NAME");

    @Test
    public void shouldReturnZeroChargeIfBalanceIsZero() {
        assertThat(calculator.calculateCharge(player)).isEqualTo(0);
    }

    @Test
    public void shouldReturnTenPercentOfBalanceCharge() {
        player.setBalance(100);
        assertThat(calculator.calculateCharge(player)).isEqualTo(10);
    }

    @Test
    public void shouldReturnTwoHundredIfTenPercentOfBalaneIsMoreThanTwoHundred() {
        player.setBalance(4000);
        assertThat(calculator.calculateCharge(player)).isEqualTo(200);
    }

}
