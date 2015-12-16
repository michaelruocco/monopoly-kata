package uk.co.mruoc.monopoly;

import org.apache.log4j.Logger;
import uk.co.mruoc.monopoly.board.Board;
import uk.co.mruoc.monopoly.board.Location;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private Logger LOG = Logger.getLogger(Player.class);

    private static final IncomeTaxCalculator INCOME_TAX_CALCULATOR = new IncomeTaxCalculator();
    private static final SalaryCalculator SALARY_CALCULATOR = new SalaryCalculator();
    private static final SuperTaxCalculator SUPER_TAX_CALCULATOR = new SuperTaxCalculator();

    private final List<Round> rounds = new ArrayList<>();
    private final List<Location> properties = new ArrayList<>();
    private final Board board;

    private final String name;
    private int position;
    private double balance;
    private int timesPassedGo;

    public Player(String name) {
        this(name, new Board());
    }

    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
    }

    public void move(int roll) {
        this.position += roll;
        while (passedGo()) {
            setPosition(getPassedGoPosition());
            incrementTimesPassedGo();
        }
        logInfo(createMoveDebugMessage(roll));
    }

    public void setPosition(int position) {
        this.position = position;
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

    private void incrementTimesPassedGo() {
        timesPassedGo++;
    }

    public double getBalance() { return balance; }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private void payIncomeTax() {
        double charge = calculateIncomeTaxCharge();
        decrementBalance(charge);
    }

    private void paySuperTax() {
        double charge = calculateSuperTaxCharge();
        decrementBalance(charge);
    }

    private void receiveSalary() {
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

    private boolean canPurchase(Location location) {
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

    private boolean hasPassedGo() {
        return timesPassedGo > 0;
    }

    public void endTurn() {
        Location location = board.getLocation(this);
        if (location.isGoToJail()) {
            setPosition(board.getJailPosition());
            return;
        }

        if (hasPassedGo())
            receiveSalary();
        if (location.isIncomeTax())
            payIncomeTax();
        if (location.isSuperTax())
            paySuperTax();
        if (canPurchase(location))
            purchase(location);
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

    private boolean passedGo() {
        return getPosition() >= board.size();
    }

    private int getPassedGoPosition() {
        return getPosition() - board.size();
    }

    private String createMoveDebugMessage(int roll) {
        Location location = board.getLocation(this);
        StringBuilder message = new StringBuilder("moved player ");
        message.append(getName());
        message.append(" ");
        message.append(roll);
        message.append(" space to board ");
        message.append(location.getName());
        return message.toString();
    }

    private void logInfo(String message) {
        LOG.info(message);
    }


}
