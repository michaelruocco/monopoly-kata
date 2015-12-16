package uk.co.mruoc.monopoly;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SalaryCalculatorTest {

    private static final int SALARY = 200;

    private final SalaryCalculator calculator = new SalaryCalculator();

    @Test
    public void shouldCalculateSalary() {
        assertThat(calculator.calculateSalary()).isEqualTo(SALARY);
    }

}
