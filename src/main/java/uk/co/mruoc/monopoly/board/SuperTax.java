package uk.co.mruoc.monopoly.board;

import uk.co.mruoc.monopoly.Player;
import uk.co.mruoc.monopoly.Roll;
import uk.co.mruoc.monopoly.SuperTaxCalculator;

public class SuperTax extends Location {

    private static final SuperTaxCalculator SUPER_TAX_CALCULATOR = new SuperTaxCalculator();

    public SuperTax() {
        super("Super Tax");
    }

    @Override
    public void applyTo(Player player, Roll roll) {
        double charge = SUPER_TAX_CALCULATOR.calculateCharge();
        player.decrementBalance(charge);
    }

}
