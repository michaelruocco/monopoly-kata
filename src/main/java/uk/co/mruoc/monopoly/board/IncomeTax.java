package uk.co.mruoc.monopoly.board;

import uk.co.mruoc.monopoly.IncomeTaxCalculator;
import uk.co.mruoc.monopoly.Player;
import uk.co.mruoc.monopoly.Roll;

public class IncomeTax extends Location {

    private static final IncomeTaxCalculator INCOME_TAX_CALCULATOR = new IncomeTaxCalculator();

    public IncomeTax() {
        super("Income Tax");
    }

    @Override
    public void applyTo(Player player, Roll roll) {
        payIncomeTax(player);
    }

    private void payIncomeTax(Player player) {
        double charge = INCOME_TAX_CALCULATOR.calculateCharge(player);
        player.decrementBalance(charge);
    }

}
