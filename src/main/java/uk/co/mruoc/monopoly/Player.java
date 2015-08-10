package uk.co.mruoc.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private static final double INCOME_TAX_RATE  = 0.1;
    private static final double MAX_INCOME_TAX_VALUE = 200;
    private static final double SUPER_TAX_VALUE = 75;
    private static final double SALARY_VALUE = 200;

    private final String name;
    private int position;
    private double balance;
    private final List<Round> rounds = new ArrayList<>();

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

    public double getBalance() { return balance; }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void payIncomeTax() {
        double incomeTaxValue = getIncomeTaxValue();
        decrementBalance(incomeTaxValue);
    }

    public void paySuperTax() {
        decrementBalance(SUPER_TAX_VALUE);
    }

    public void recieveSalary() {
        incrementBalance(SALARY_VALUE);
    }

    private void incrementBalance(double valueToAdd) {
        balance += valueToAdd;
    }

    private void decrementBalance(double valueToSubtract) {
        balance -= valueToSubtract;
    }

    private double getIncomeTaxValue() {
        double incomeTaxValue = balance * INCOME_TAX_RATE;
        if (incomeTaxValue > MAX_INCOME_TAX_VALUE)
            return MAX_INCOME_TAX_VALUE;
        return incomeTaxValue;
    }

}
