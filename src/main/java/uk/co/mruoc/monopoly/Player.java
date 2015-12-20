package uk.co.mruoc.monopoly;

import org.apache.log4j.Logger;
import uk.co.mruoc.monopoly.board.*;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private Logger LOG = Logger.getLogger(Player.class);

    private static final SalaryCalculator SALARY_CALCULATOR = new SalaryCalculator();

    private final List<Round> rounds = new ArrayList<>();
    private final List<Property> properties = new ArrayList<>();
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

    public void addProperty(Property location) {
        properties.add(location);
    }

    public boolean ownsProperty(Property propertyToCheck) {
        return ownsProperty(propertyToCheck.getName());
    }

    public boolean ownsProperty(String propertyName) {
        for (Property property : properties)
            if (property.getName().equalsIgnoreCase(propertyName))
                return true;
        return false;
    }

    public void decrementBalance(double valueToSubtract) {
        balance -= valueToSubtract;
    }

    public void incrementBalance(double valueToAdd) {
        balance += valueToAdd;
    }

    public void endTurn() {
        Location location = board.getLocation(this);
        if (isGoToJail(location)) {
            location.applyTo(this);
            return;
        }

        if (hasPassedGo())
            receiveSalary();

        location.applyTo(this);
    }
    ;
    public int getNumberOfTrainStationsOwned() {
        int trainStationCount = 0;
        for (Location location : properties)
            if (location instanceof TrainStation)
                trainStationCount++;
        return trainStationCount;
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

    private void incrementTimesPassedGo() {
        timesPassedGo++;
    }

    private void logInfo(String message) {
        LOG.info(message);
    }

}
