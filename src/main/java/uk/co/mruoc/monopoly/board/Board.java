package uk.co.mruoc.monopoly.board;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class Board {

    private static final Locations DEFAULT_LOCATIONS = new DefaultLocations();

    private final Locations locations;
    private final Map<String, Integer> playerLocations = new HashMap<>();

    public Board() {
        this(DEFAULT_LOCATIONS);
    }

    public int size() {
        return locations.getNumberOfLocations();
    }

    public void addPlayer(String playerName) {
        placePlayer(playerName, 0);
    }

    public Location movePlayer(String playerName, int placesToMove) {
        int originalLocation = getLocation(playerName);
        int newLocation = calculateNewLocation(originalLocation, placesToMove);
        placePlayer(playerName, newLocation);
        return locations.get(newLocation);
    }

    public void placePlayer(String playerName, String locationName) {
        int location = locations.get(locationName);
        playerLocations.put(playerName, location);
    }

    public void placePlayer(String playerName, int location) {
        playerLocations.put(playerName, location);
    }

    public int getLocation(String playerName) {
        return playerLocations.get(playerName);
    }

    public String getLocationName(String playerName) {
        int playerLocation = playerLocations.get(playerName);
        Location location = locations.get(playerLocation);
        return location.getName();
    }

    private int calculateNewLocation(int originalLocation, int placesToMove) {
        int newLocation = originalLocation + placesToMove;
        int size = locations.getNumberOfLocations();
        if (newLocation < size) {
            return newLocation;
        }
        return newLocation - size;
    }

}
