package uk.co.mruoc.monopoly;

public class IncomeTaxCalculator {

    private static final double RATE  = 0.1;
    private static final double MAX_CHARGE = 200;

    public double calculate(Player player) {
        double charge = calculateCharge(player);
        if (aboveMaxCharge(charge))
            return MAX_CHARGE;
        return charge;
    }

    private double calculateCharge(Player player) {
        return player.getBalance() * RATE;
    }

    private boolean aboveMaxCharge(double charge) {
        return charge > MAX_CHARGE;
    }

}
