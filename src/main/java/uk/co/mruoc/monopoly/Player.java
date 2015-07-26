package uk.co.mruoc.monopoly;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String name;
    private int position = 0;
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

}
