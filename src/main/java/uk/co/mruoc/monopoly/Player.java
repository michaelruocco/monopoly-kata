package uk.co.mruoc.monopoly;

import org.apache.log4j.Logger;
import uk.co.mruoc.monopoly.board.*;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private Logger LOG = Logger.getLogger(Player.class);

    private static final SalaryCalculator SALARY_CALCULATOR = new SalaryCalculator();

    private final List<Round> rounds = new ArrayList<>();
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

    public void move(int rollValue) {
        move(new Roll(rollValue, 0));
    }

    public void move(Roll roll) {
        this.position += roll.value();
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

    public double getBalance() { return balance; }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private void receiveSalary() {
        double salary = SALARY_CALCULATOR.calculateSalary();
        double payment = salary * timesPassedGo;
        incrementBalance(payment);
        resetTimesPassedGo();
    }

    public boolean hasLost() {
        return hasNegativeBalance();
    }

    public String getName() {
        return name;
    }

    public void decrementBalance(double valueToSubtract) {
        balance -= valueToSubtract;
    }

    public void incrementBalance(double valueToAdd) {
        balance += valueToAdd;
    }

    public void endTurn(int rollValue) {
        endTurn(new Roll(rollValue, 0));
    }

    public void endTurn(Roll roll) {
        Location location = board.getLocation(this);
        if (isGoToJail(location)) {
            location.applyTo(this, roll);
            return;
        }

        if (hasPassedGo())
            receiveSalary();

        location.applyTo(this, roll);
    }

    public boolean canAfford(Property property) {
        return balance >= property.getCost();
    }

    private boolean hasPassedGo() {
        return timesPassedGo > 0;
    }

    private boolean isGoToJail(Location location) {
        return (location instanceof GoToJail);
    }

    private boolean hasNegativeBalance() {
        return balance < 0;
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

    private String createMoveDebugMessage(Roll roll) {
        Location location = board.getLocation(this);
        StringBuilder message = new StringBuilder("moved player ");
        message.append(getName());
        message.append(" ");
        message.append(roll.value());
        message.append(" spaces to ");
        message.append(location.getName());
        return message.toString();
    }

    private void incrementTimesPassedGo() {
        timesPassedGo++;
    }

    private void logInfo(String message) {
        LOG.info(message);
    }

    public void moveToJail() {
        position = board.getJailPosition();
    }

}
