package uk.co.mruoc.monopoly.board;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class Board {

    private static final int DEFAULT_SIZE = 40;

    private final Map<String, Integer> playerLocations = new HashMap<>();

    private final int size;

    public Board() {
        this(DEFAULT_SIZE);
    }

    public int size() {
        return size;
    }

    public void addPlayer(String playerName) {
        placePlayer(playerName, 0);
    }

    public void movePlayer(String playerName, int placesToMove) {
        int originalLocation = getLocation(playerName);
        int newLocation = calculateNewLocation(originalLocation, placesToMove);
        placePlayer(playerName, newLocation);
    }

    public void placePlayer(String playerName, int location) {
        playerLocations.put(playerName, location);
    }

    public int getLocation(String playerName) {
        return playerLocations.get(playerName);
    }

    private int calculateNewLocation(int originalLocation, int placesToMove) {
        int newLocation = originalLocation + placesToMove;
        if (newLocation < size) {
            return newLocation;
        }
        return newLocation - size;
    }

}
