package uk.co.mruoc.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private static final IncomeTaxCalculator INCOME_TAX_CALCULATOR = new IncomeTaxCalculator();
    private static final SalaryCalculator SALARY_CALCULATOR = new SalaryCalculator();
    private static final SuperTaxCalculator SUPER_TAX_CALCULATOR = new SuperTaxCalculator();

    private final List<Round> rounds = new ArrayList<>();
    private final List<Location> properties = new ArrayList<>();

    private final String name;
    private int position;
    private double balance;
    private int timesPassedGo;

    public Player(String name) {
        this.name = name;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void move(int roll) {
        this.position += roll;
    }

    public int getPosition() {
        return position;
    }

    public boolean nameIs(String nameToMatch) {
        return name.equals(nameToMatch);
    }

    public int getNumberOfRoundsPlayed() {
        return rounds.size();
    }

    public void addRound(Round round) {
        rounds.add(round);
    }

    public void incrementTimesPassedGo() {
        timesPassedGo++;
    }

    public double getBalance() { return balance; }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void payIncomeTax() {
        double charge = calculateIncomeTaxCharge();
        decrementBalance(charge);
    }

    public void paySuperTax() {
        double charge = calculateSuperTaxCharge();
        decrementBalance(charge);
    }

    public void receiveSalary() {
        double payment = calculateSalaryPayment();
        incrementBalance(payment * timesPassedGo);
        resetTimesPassedGo();
    }

    public boolean hasLost() {
        return hasNegativeBalance();
    }

    public boolean isStillPlaying() {
        return !hasLost();
    }

    public String getName() {
        return name;
    }

    public boolean canPurchase(Location location) {
        if (location.hasOwner())
            return false;
        return canAfford(location);
    }

    public void purchase(Location location) {
        decrementBalance(location.getCost());
        properties.add(location);
        location.setOwner(this);
    }

    public boolean ownsProperty(String propertyName) {
        for (Location location : properties)
            if (location.getName().equalsIgnoreCase(propertyName))
                return true;
        return false;
    }

    public boolean hasPassedGo() {
        return timesPassedGo > 0;
    }

    private boolean hasNegativeBalance() {
        return balance < 0;
    }

    private boolean canAfford(Location location) {
        return balance > location.getCost();
    }

    private void incrementBalance(double valueToAdd) {
        balance += valueToAdd;
    }

    private void decrementBalance(double valueToSubtract) {
        balance -= valueToSubtract;
    }

    private double calculateSalaryPayment() {
        return SALARY_CALCULATOR.calculate();
    }

    private double calculateIncomeTaxCharge() {
        return INCOME_TAX_CALCULATOR.calculate(this);
    }

    private double calculateSuperTaxCharge() {
        return SUPER_TAX_CALCULATOR.calculate();
    }

    private void resetTimesPassedGo() {
        timesPassedGo = 0;
    }

}
