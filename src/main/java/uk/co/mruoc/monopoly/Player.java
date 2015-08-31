package uk.co.mruoc.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private static final IncomeTaxCalculator INCOME_TAX_CALCULATOR = new IncomeTaxCalculator();
    private static final SalaryCalculator SALARY_CALCULATOR = new SalaryCalculator();
    private static final SuperTaxCalculator SUPER_TAX_CALCULATOR = new SuperTaxCalculator();

    private final String name;
    private int position;
    private double balance;
    private final List<Round> rounds = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
        incrementBalance(payment);
    }

    public boolean hasLost() {
        return hasNegativeBalance();
    }

    private boolean hasNegativeBalance() {
        return balance < 0;
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

}
